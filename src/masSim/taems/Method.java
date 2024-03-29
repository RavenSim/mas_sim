package masSim.taems;

import masSim.util.Log;

public class Method implements IMethod {

	private String name;
	private int duration;
	private int index;

	// Constructor
	public Method(String nm, int dr) {
		name = nm;
		duration = dr;
		index = 1;
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
		Log.getLogger().info("Executing method " + name);
	}
}