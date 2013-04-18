package masSim.main;

import java.util.logging.Level;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

import masSim.util.Log;
import masSim.world.World;

public class MasSim {
	private static World world;
	volatile static boolean alive;

	public static void main(String args[]) {
		// Clean up the log for debugging purposes
		Log.getLogger().setLevel(Level.INFO);
		Log.getLogger().setFilter(new Filter() {
			public boolean isLoggable(LogRecord r) {
				return r.getLevel() != Level.WARNING;
			}
		});

		// Total number of agents to be worked with
		int total_agents;
		total_agents = 3;
		world = new World(total_agents);
		alive = true;

		simLoop();
	}

	// ////////////////////////////////////////////////////////////////////////
	// Game simulation

	public static void setAlive(boolean status) {
		alive = status;
	}

	private static void simLoop() {
		Log.getLogger().info("MasSim loop starting...");
		long lastTime = System.nanoTime();

		while (alive) {
			long currentTime = System.nanoTime();

			world.update((currentTime - lastTime) * 1.0e-9);

			long millisToNextUpdate = Math
					.max(0, (1000 / 60)
							- ((System.nanoTime() - currentTime) / 1000000));

			lastTime = currentTime;
			try {
				Thread.sleep(millisToNextUpdate);
			} catch (InterruptedException e) {
				break;
			}
		}
		Log.getLogger().info("MasSim finished...");
	}
}