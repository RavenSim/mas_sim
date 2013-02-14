package masSim.main;

/*
import raven.game.RavenGame;
import raven.ui.GameCanvas;
import raven.ui.RavenUI;
import raven.utils.Log;
import raven.utils.MapLoadedException;
import raven.utils.Log.Level;
*/
import masSim.world.World;

public class MasSim {
//		private static RavenUI ui;
		private static World world;
		volatile static boolean alive;
		
	    public static void main(String args[]) {
//	    	Log.setLevel(Level.INFO);
	    	
//	    	game = new RavenGame();
//	    	ui = new RavenUI(game);
	
	    	world = new World();
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

//	    		try{
	    		world.update((currentTime - lastTime) * 1.0e-9);
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
}
