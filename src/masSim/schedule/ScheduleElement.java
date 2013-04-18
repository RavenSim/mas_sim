package masSim.schedule;

import masSim.util.Log;

public class ScheduleElement {
	  private String title = "";

	  public ScheduleElement(String newTitle) {
		  title = newTitle;
		  Log.getLogger().info("Schedule Element created with title: " + title);
	  }

	  public void setTitle(String newTitle) {
		  title = newTitle;
	  }

	  public String getTitle(){
		  return title;
	  }
}
