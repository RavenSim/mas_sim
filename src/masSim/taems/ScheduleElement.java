package masSim.taems;

import masSim.util.Log;

public class ScheduleElement {
	private String name;
	private Method method;
	private int duration;
	private int elapsedTime;
	private Status status;
	public static int sleepTime = 300;

	public enum Status {
		ACTIVE, COMPLETED
	}

	// Constructor
	public ScheduleElement(Method mt) {
		if (mt == null) {
			throw new NullMethod(
					"ScheduleElement.Constructor: Null method passed");
		}

		this.name = mt.generateName();
		this.method = mt;
		duration = mt.getDuration();
		elapsedTime = 0;
		status = Status.ACTIVE;

		Log.getLogger().info("Schedule Element created with name: " + name);
	}

	public String getName() {
		return name;
	}

	public synchronized Status update(int dt) {
		int expectedTime = elapsedTime + dt;
		if (expectedTime >= duration) {
			elapsedTime = duration;
			status = Status.COMPLETED;
		} else {
			elapsedTime += dt;
		}
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			Log.getLogger().info("Thread sched el " + name + " interrupted");
		}
		return status;
	}

	public Status getStatus() {
		return status;
	}

}
