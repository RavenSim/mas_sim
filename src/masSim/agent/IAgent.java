package masSim.agent;

import masSim.schedule.ScheduleElement;

public interface IAgent {
	public int getCode();
	public void assignGoal(ScheduleElement goal);
}
