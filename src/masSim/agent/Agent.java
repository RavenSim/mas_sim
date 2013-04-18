package masSim.agent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import masSim.util.Log;
import masSim.taems.ITask;
import masSim.taems.Method;
import masSim.taems.Schedule;
import masSim.taems.ScheduleElement;

public class Agent implements IAgent, Runnable {
	private enum Status {
		IDLE, PROCESSNG, EMPTY
	}

	private int code;
	private String name;
	private Schedule sched;
	private List<ITask> taskAbilities;
	private List<ITask> curTasks;
	private int taskInd;
	private Status status;

	// Constructor
	public Agent(int newCode) {
		taskInd = 0;
		code = newCode;
		status = Status.EMPTY;
		sched = new Schedule();
		name = "Agent" + newCode;
		curTasks = new ArrayList<ITask>();
		taskAbilities = new ArrayList<ITask>();

		Log.getLogger().info("Agent created with code " + code);
	}

	public Agent(int ID, String name) {
		this(ID);
		this.name = name;
	}

	// Returns identifying code, specific for this agent
	public int getCode() {
		return code;
	}

	private void negotiate() {
		// pretending to negotiate
	}

	private synchronized void schedule(ITask task) {
		// pretending to schedule
		Iterator<Method> iterLeaves = task.getLeaves();
		while(iterLeaves.hasNext()) {
			Method m = iterLeaves.next();
			ScheduleElement el = new ScheduleElement(m);
			sched.addItem(el);
		}
	}

	public void addTaskAbility(ITask task) {
		taskAbilities.add(task);
	}

	/**
	 * this method handles the assignment goals
	 */
	public void assignTask(ITask task) {
		curTasks.add(task);
		schedule(task);
		negotiate();

		Log.getLogger().info("Agent: " + code + " - Task " + task.getName() + " Assigned");
	}

	/**
	 * Update the schedule with a tick size
	 *
	 * @param tick
	 */

	public synchronized void update(int tick) {

		if(sched.hasNext(taskInd)) {
			ScheduleElement el = sched.peek();
			ScheduleElement.Status status = el.update(tick);
			if(status == ScheduleElement.Status.COMPLETED) {
				sched.poll();
				Log.getLogger().info("Agent " + name + " completed item " + el.getName());
			}
		}
		else {
			Log.getLogger().warning("Agent " + name + " idle");
		}
	}

	/**
	 * Getter for the bot status
	 */

	public boolean idle() {
		return status == Status.IDLE;
	}

	/**
	 * Method required to implement `Runnable`
	 */

	public void run() {
		while(true) {
			update(1);
		}
	}
}
