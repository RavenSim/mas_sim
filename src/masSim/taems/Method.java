package masSim.taems;

public class Method implements ITaskBase {

	private String name;
	private int duration;
	private int index;

	// Constructor
	public Method(String nm, int dr){
		name = nm;
		duration = dr;
		index = 1;
	}
	public String getName(){return name;}
//	public void SetDuration(int newDur){duration = newDur;}
	public int getDuration(){return duration;}

	public String generateName(){
		String resName = name + Integer.toString(index);
		index++;
		return resName;
	}
}
