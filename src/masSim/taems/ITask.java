package masSim.taems;

import java.util.Iterator;

public interface ITask extends ITaskBase{

	// Accessors
	public String getName();
	public QAF getQAF();

	// Modifiers
	public void addMethod(IMethod mt);
	public void addLeaf(IMethod mt);
	public Iterator<IMethod> getLeaves();
	public void addTask(ITask task);
}
