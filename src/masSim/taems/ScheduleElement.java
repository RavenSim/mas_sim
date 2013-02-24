package masSim.taems;

import java.util.*;
import java.io.*;
import java.awt.*;

public class ScheduleElement {
	  private String name;
	  private Method method;
	  private int duration;
	  private int elapsedTime;
	  private Status status;
	  public enum Status {
		    ACTIVE, COMPLETED 
		}
	  
	  // Constructor
	  public ScheduleElement(Method mt){
		  
		  if (mt == null){
			  throw new NullMethod("ScheduleElement.Constructor: Null method passed");
		  }

		  this.name = mt.generateName();
		  this.method = mt;
		  duration = mt.getDuration();
		  elapsedTime = 0;
		  status = Status.ACTIVE;
		  
		  System.out.println("Schedule Element created with name: " + name);
	  }

	  public String getName(){
		  return name;
	  }	  
	  
	  public Status update(int dt){
		  int expectedTime = elapsedTime + dt;
		  if ( expectedTime >= duration){
			  elapsedTime = duration;
			  status = Status.COMPLETED;
		  }
		  else{
			  elapsedTime += dt;
		  }
		  return status;
	  }
	  
	  public Status getStatus(){return status;}
	  
}
