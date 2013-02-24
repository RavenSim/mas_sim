
package masSim.taems;

public interface ITask extends ITaskBase{

	// Accessors
	public String getName();
	public QAF getQAF();

	// Modifiers
	public void addMethod(Method mt);	
	public void addTask(ITask task);
}
