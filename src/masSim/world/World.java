package masSim.world;

import java.util.List;
import java.util.ArrayList;

import masSim.agent.IAgent;
import masSim.main.*;
import masSim.agent.*;
import masSim.schedule.*;

public class World {
	
	private int ticks = 1;
	public final static int maxTicks = 10;
	/** bots that inhabit the current map */
	private List<IAgent> agents;
	
	// Blank constructor
	public World(){	
	}
	
	// Constructor
	public World(int total_agents){
		agents = new ArrayList<IAgent>();
		
		for (int i = 0; i < total_agents; i++){
			Agent agent = new Agent(i);
			agents.add(agent);
		}
	}
		
	public void update(String action){
		for(IAgent agent : agents) {
			if (action.equals("Q")){
				MasSim.setAlive(false);
			}
			else{
				ScheduleElement goal = new ScheduleElement(action);
				agent.assignGoal(goal);
			}
		}
	}
}
