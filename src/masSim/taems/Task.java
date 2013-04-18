package masSim.taems;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import masSim.util.Log;

public class Task implements ITask {
	private String name;
	private QAF qaf;
	private List<ITaskBase> children;
	private List<Method> leaves;

	// Constructor
	public Task(String name, QAF qaf) {
		this.name = name;
		children = new ArrayList<ITaskBase>();
		leaves = new ArrayList<Method>();
		this.qaf = qaf;
	}

	// Accessors
	public String getName() {
		return name;
	}

	public void addMethod(Method mt) {
		children.add(mt);
		Log.getLogger().info("Task: " + name + " - Children: " + mt.getName()
				+ " added");
	}

	public void addTask(ITask task) {
		children.add(task);
		Log.getLogger().info("Task: " + name + " - Task: " + task.getName()
				+ " added");
	}

	public void addLeaf(Method m) {
		leaves.add(m);
	}

	public Iterator<Method> getLeaves() {
		return leaves.iterator();
	}

	public QAF getQAF() {
		return qaf;
	}
}
