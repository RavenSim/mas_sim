package masSim.main;

/*
import raven.game.RavenGame;
import raven.ui.GameCanvas;
import raven.ui.RavenUI;
import raven.utils.Log;
import raven.utils.MapLoadedException;
import raven.utils.Log.Level;
*/
import masSim.schedule.ScheduleElement;
import masSim.world.World;

import java.io.IOException;
import java.util.Scanner;
 
public class MasSim {
//		private static RavenUI ui;
		private static World world;
		volatile static boolean alive;
		

	    public static void main(String args[]) {
//	    	Log.setLevel(Level.INFO);
	    	
//	    	game = new RavenGame();
//	    	ui = new RavenUI(game);

	    	// Ask user for total of agents to work with
    		//System.out.println("(A)ssign task    (Q)uit");
    		//int total_agents = readInput();
    		int total_agents = 1;
    		
	    	world = new World(total_agents);
	    	alive = true;
	    	
	    	simLoop();
	    }
	    
		//////////////////////////////////////////////////////////////////////////
		// Game simulation

	    public static void setAlive(boolean status){
	    	alive = status;
	    }
	    
		private static void simLoop() {
	    	
//	    	Log.info("raven", "Starting game...");
			System.out.println("MasSim starting...");
	    	long lastTime = System.nanoTime();
	    	
	    	while (alive) {
	    		
	    		// TODO Resize UI if the map changes!
//	    		boolean loadedMap = false;

	    		long currentTime = System.nanoTime();

	    		System.out.println("(A)ssign task    (Q)uit");
	    		
	    		String input = readInput();
	    		
	    		if (input.equals("A")){
	    			System.out.println("Task Label:");
	    			
	    			input = readInput();
	    		}	
	    		    		
//	    		try{
	    		world.update(input);
//	    		}
/*	    		catch (MapLoadedException e){
	    			loadedMap = true;
	    			ui.dispose();
	    	    	ui = new RavenUI(game);

	    		}
	    		// Always dispose the canvas
	    		try {
	    			GameCanvas.startDrawing(game.getMap().getSizeX(), game.getMap().getSizeY(), loadedMap);
	    			loadedMap = false;
	    			game.render();
	    		} finally {
	    			GameCanvas.stopDrawing();
	    		}
*/
	    		long millisToNextUpdate = Math.max(0, (1000 / 60) - ((System.nanoTime() - currentTime) / 1000000));
				lastTime = currentTime;
				try {
					Thread.sleep(millisToNextUpdate);
				} catch (InterruptedException e) {
					break;
				}
	    	}
	    	System.out.println("MasSim finished...");
	   }
		// User interface mock
		public static String readInput() {
			String s = ""; 		 
			Scanner user_input = new Scanner( System.in );
			s = user_input.next( );			    
		    return s;
		  }	
}