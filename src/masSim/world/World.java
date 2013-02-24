package masSim.world;

import java.util.List;
import java.util.ArrayList;

import masSim.agent.IAgent;
import masSim.main.*;
import masSim.agent.*;
import masSim.taems.*;

public class World {
	
	private int ticks = 1;
	public final static int maxTicks = 10;
	
	/** Agents that inhabit the current world */
	private List<IAgent> agents;
	private List<ITask> tasks;
	
	// Blank constructor
	public World(){	
	}
	
	// Constructor
	public World(int total_agents){
		agents = new ArrayList<IAgent>();
		int total_tasks = total_agents;

		// Create a fixed number of agents
		int index = 0;
		while(index < total_agents){
			Agent agent = new Agent(index);
			agents.add(agent);
			index++;
		}
		System.out.println( index + " agents loaded...");	
		
		// Creation of sample tasks
		tasks = new ArrayList<ITask>();

		for (index = 0; index < total_tasks; index++){
			SeqSumQAF seqSum = new SeqSumQAF();
			String taskName = "Cover_" + index;
			ITask newTask = new Task(taskName, seqSum);
			tasks.add(newTask);
		}
		
		System.out.println( index + " Tasks loaded...");	
		
	}
		
	// To do...
	// Class for non-local tasks
	public void update(double dt){
		try {
			Thread.sleep(300); System.out.println("World updated with dt: " + dt );
			ticks++;
			
			System.out.println( "Tasks in memory: " + tasks.size());	
			
			if (tasks.isEmpty()){
				MasSim.setAlive(false);
			}
		} catch (InterruptedException e) {
			System.out.println("Thread interrupted");
		}
	}
}
