package masSim.taems;

import masSim.util.Log;
import masSim.agent.Agent;

public class DelegateMethod implements IMethod {

	private String name;
	private int duration;
	private Agent delegate;
	private ITask task;
	private int index;

	// Constructor
	public DelegateMethod(String nm, int dr, Agent a, ITask t) {
		name = nm;
		duration = dr;
		index = 1;
		delegate = a;
		task = t;
	}
	
	public String getName() {
		return name;
	}

	public int getDuration() {
		return duration;
	}

	public String generateName() {
		String resName = name + Integer.toString(index);
		index++;
		return resName;
	}
	
	public void execute() {
		Log.getLogger().info("Delegating " + task.getName() + " to " + delegate.getName());
		delegate.assignTask(task);
	}
}