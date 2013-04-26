package masSim.world;

import java.util.ArrayList;
import java.util.List;

import masSim.agent.Agent;
import masSim.taems.ITask;
import masSim.taems.Method;
import masSim.taems.DelegateMethod;
import masSim.taems.SeqSumQAF;
import masSim.taems.Task;
import masSim.util.Log;

public class World {
	private int ticks = 0;
	public final static int maxTicks = 4000;

	/** Agents that inhabit the current world */
	private List<Agent> agents;

	private Agent ag1;
	private Agent ag2;
	private ITask transTask;
	private ITask cleanTask;

	// private List<ITask> tasks;

	// Blank constructor
	public World() {
	}

	// Constructor
	public World(int total_agents) {
		agents = new ArrayList<Agent>();
		// int total_tasks = total_agents;
		ag1 = new Agent(0, "Blackbird");
		ag2 = new Agent(1, "Kiowa");

		agents.add(ag1);
		agents.add(ag2);
		// Create a fixed number of agents
		/*
		 * int index = 0; while(index < total_agents){ Agent agent = new
		 * Agent(index); agents.add(agent); index++; } Log.getLogger().info(
		 * index + " agents loaded...");
		 */
		// Creation of sample tasks
		/*
		 * tasks = new ArrayList<ITask>();
		 *
		 * for (index = 0; index < total_tasks; index++){ SeqSumQAF seqSum = new
		 * SeqSumQAF(); String taskName = "Cover_" + index; ITask newTask = new
		 * Task(taskName, seqSum); tasks.add(newTask); }
		 */

		// initialize execution threads
		for (Agent a : agents) {
			new Thread(a).start();
		}

		// transport task creation
		SeqSumQAF seqSum = new SeqSumQAF();
		transTask = new Task("Transport", seqSum);
		ITask transSub1 = new Task("TransPickUp", seqSum);
		transTask.addTask(transSub1);
		Method tr1 = new Method("Fly to source", 5);
		Method tr2 = new Method("Land at source", 2);
		Method tr3 = new Method("Pick up at source", 3);

		transTask.addLeaf(tr1);
		transTask.addLeaf(tr2);
		transTask.addLeaf(tr3);

		transSub1.addMethod(tr1);
		transSub1.addMethod(tr2);
		transSub1.addMethod(tr3);

		ITask transSub2 = new Task("TransDeliver", seqSum);
		transTask.addTask(transSub2);
		Method tr4 = new Method("Fly to dest", 15);
		Method tr5 = new Method("Land at dest", 2);
		Method tr6 = new Method("Unload at dest", 3);
		transTask.addLeaf(tr4);
		transTask.addLeaf(tr5);
		transTask.addLeaf(tr6);

		transSub2.addMethod(tr4);
		transSub2.addMethod(tr5);
		transSub2.addMethod(tr6);

		ag1.addTaskAbility(transTask);

		// cleanup task creation
		SeqSumQAF seqSum2 = new SeqSumQAF();
		cleanTask = new Task("Clean LZ", seqSum2);
		ITask cleanSub1 = new Task("CleanStart", seqSum2);
		cleanTask.addTask(cleanSub1);
		Method cl1 = new Method("Fly to clean up source", 7);
		Method cl2 = new Method("Start search and destroy", 10);

		cleanTask.addLeaf(cl1);
		cleanTask.addLeaf(cl2);

		cleanSub1.addMethod(cl1);
		cleanSub1.addMethod(cl2);

		ITask cleanSub2 = new Task("CLeanEnd", seqSum2);
		cleanTask.addTask(cleanSub2);
		Method cl3 = new Method("Fly to clean up dest", 15);
		Method cl4 = new Method("Stop search and destroy", 2);
		Method cl5 = new Method("Reschedule default activity", 2);
		cleanSub1.addMethod(cl3);

		cleanTask.addLeaf(cl3);
		cleanTask.addLeaf(cl4);
		cleanTask.addLeaf(cl5);

		cleanSub2.addMethod(cl3);
		cleanSub2.addMethod(cl4);
		cleanSub2.addMethod(cl5);
		
		// Delegate the clean method to ag1
		DelegateMethod dm1 = new DelegateMethod("Agent 2 pick up", 
				4, ag1, cleanTask);
		
		//Schedule it in a new team task
		ITask delegate = new Task("Team clean", seqSum2);
		delegate.addLeaf(dm1);
		ag1.assignTask(delegate);

		ag2.assignTask(cleanTask);
	}

	// To do...
	// Class for non-local tasks
	public void update(double dt) {
		if (ticks == 11)
			ag1.assignTask(transTask);
		if (ticks == 16)
			ag2.assignTask(cleanTask);
		ticks++;

		Log.getLogger().fine("Tick: " + ticks);
		if(ticks > maxTicks) {
			Log.getLogger().info("Exiting masSim");
			System.exit(0);
		}
		/*
		 * if (tasks.isEmpty()){ MasSim.setAlive(false); }
		 *
		 * } catch (InterruptedException e) {
		 * Log.getLogger().info("Thread interrupted"); }
		 */
	}
}
