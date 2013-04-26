package masSim.taems;

public interface IMethod extends ITaskBase {
	public String getName();
	public int getDuration();
	public String generateName();
	public void execute();
}