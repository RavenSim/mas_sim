package masSim.taems;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import masSim.util.Log;

public class Task implements ITask {
	private String name;
	private QAF qaf;
	private List<ITaskBase> children;
	private List<IMethod> leaves;

	// Constructor
	public Task(String name, QAF qaf) {
		this.name = name;
		children = new ArrayList<ITaskBase>();
		leaves = new ArrayList<IMethod>();
		this.qaf = qaf;
	}

	// Accessors
	public String getName() {
		return name;
	}

	public void addMethod(IMethod mt) {
		children.add(mt);
		Log.getLogger().info("Task: " + name + " - Children: " + mt.getName()
				+ " added");
	}

	public void addTask(ITask task) {
		children.add(task);
		Log.getLogger().info("Task: " + name + " - Task: " + task.getName()
				+ " added");
	}

	public void addLeaf(IMethod m) {
		leaves.add(m);
	}

	public Iterator<IMethod> getLeaves() {
		return leaves.iterator();
	}

	public QAF getQAF() {
		return qaf;
	}
}
