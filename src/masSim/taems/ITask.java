package masSim.taems;

import java.util.Iterator;

public interface ITask extends ITaskBase{

	// Accessors
	public String getName();
	public QAF getQAF();

	// Modifiers
	public void addMethod(Method mt);
	public void addLeaf(Method mt);
	public Iterator<Method> getLeaves();
	public void addTask(ITask task);
}
