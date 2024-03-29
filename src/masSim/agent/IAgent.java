package masSim.agent;

import masSim.taems.*;

public interface IAgent {
	public int getCode();
	public void assignTask(ITask task);
	public void addTaskAbility(ITask task);
	public void update(int tick);
}
