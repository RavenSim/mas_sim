
package masSim.taems;

import java.util.List;
import java.util.ArrayList;

public class Task implements ITask{

	private String name;
	private QAF qaf;
	private List<ITaskBase> children;
	
	// Constructor
	public Task(String name, QAF qaf){
		this.name = name;
		children = new ArrayList<ITaskBase>();
		this.qaf = qaf;
		}
	
	// Accessors
	public String getName(){return name;}

	public void addMethod(Method mt){
		children.add(mt);
		System.out.println("Task: " + name + " - Children: " + mt.getName() + " added");
	}
	
	public void addTask(ITask task){
		children.add(task);
		System.out.println("Task: " + name + " - Task: " + task.getName() + " added");
	}
	
	public QAF getQAF(){return qaf;}
}
