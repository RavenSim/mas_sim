package masSim.agent;

import masSim.world.*;
import masSim.taems.*;

import java.util.*;

public class Agent implements IAgent{

	private int code;
	private String name;
	private Schedule sched;
	private List<ITask> taskAbilities;
	private List<ITask> curTasks;
	private int taskInd;
	
	private enum Status {
		IDLE, PROCESSNG, EMPTY
	}
	
	/** alive, dead or spawning? */
	private Status status;

	/** a pointer to the world data */
	//private World agentWorld;
	
	
	// Constructor
	public Agent(int newCode){
		code = newCode;
		sched = new Schedule();
		curTasks = new ArrayList<ITask>();
		taskAbilities = new ArrayList<ITask>();
		taskInd = 0;
		status = Status.EMPTY;
		name = "Agent" + newCode;
		//agentWorld = new World();
		System.out.println("Agent created with code" + code);
	}
	
	public Agent(int ID, String name){
		this(ID);
		this.name = name;
	}
	// Returns identifying code, specific for this agent
	public int getCode(){
		return code;
	}	

	private void negotiate() {
		// pretending to negotiate
		
	}
	private void schedule(ITask task) {
		// pretending to schedule
		Iterator<Method> iterLeaves = task.getLeaves();
		while(iterLeaves.hasNext()) {
			Method m = iterLeaves.next();
			ScheduleElement el = new ScheduleElement(m);
			sched.addItem(el);
		}
	}
	
	public void addTaskAbility(ITask task){
		taskAbilities.add(task);
	}
	
	/**
	 * this method handles the assignment goals
	 */
	public void assignTask(ITask task){
		System.out.println("Agent: " + code + " - Task " + task.getName() + " Assigned");
		curTasks.add(task);
		schedule(task);
		negotiate();
	}
	public void update(int tick) {
		
		if(sched.hasNext(taskInd)) {
			ScheduleElement el = sched.peek();
			ScheduleElement.Status status = el.update(tick);
			if(status == ScheduleElement.Status.COMPLETED) {
				System.out.println("Agent " + name + " completed item " + el.getName());
				sched.poll();
			}
		}
		else {
			System.out.println("Agent " + name + " idle");
		}
	}
}
