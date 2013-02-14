package masSim.world;

import masSim.main.*;

public class World {
	
	private int ticks = 0;
	public final static int maxTicks = 10;
	
	public void update(double dt){
		try {
			Thread.sleep(300); System.out.println("World updated with dt: " + dt );
			ticks++;
			if (ticks > maxTicks){
				MasSim.setAlive(false);
			}
		} catch (InterruptedException e) {
			System.out.println("Thread interrupted");
		}
	}
}
