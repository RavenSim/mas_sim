package masSim.agent;

import masSim.world.*;
import masSim.taems.*;

import java.util.*;

public class Agent implements IAgent{

	private int code;
	private Task curTask;
	
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
		System.out.println("Agent created with code" + code);
	}
	
	// Returns identifying code, specific for this agent
	public int getCode(){
		return code;
	}	

	/**
	 * this object handles the assignment goals
	 */
	public void assignTask(Task task){
		System.out.println("Agent: " + code + " - Task " + task.getName() + " Assigned");
		curTask = task;
		
	}
	
}
