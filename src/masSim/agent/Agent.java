package masSim.agent;

import masSim.world.World;
import masSim.schedule.ScheduleElement;
import java.util.*;

public class Agent implements IAgent{

	private int code;
	private ScheduleElement curTask;
	
	private enum Status {
		IDLE, PROCESSNG, EMPTY
	}
	
	/** alive, dead or spawning? */
	private Status status;

	/** a pointer to the world data */
	private World agentWorld;
	
	
	// Constructor
	public Agent(int newCode){
		code = newCode;
		curTask = null;
		status = Status.EMPTY;
		agentWorld = new World();
	}
	
	// Returns identifying code, specific for this agent
	public int getCode(){
		return code;
	}	

	/**
	 * this object handles the assignment goals
	 */
	public void assignGoal(ScheduleElement goal){
		System.out.println("Goal" + goal.getTitle() + " Assigned");
		curTask = goal;
		
	}
	
}
