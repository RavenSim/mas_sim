package masSim.test;

import java.util.ArrayList;
import masSim.agent.Agent;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MultithreadingTest {
	private ArrayList<Agent> agents;
	private final int AGENTS = 20;
	
	@Before
	public void setup() {
		agents = new ArrayList<Agent>();

		for(int i = 1; i <= AGENTS; i++) {
			agents.add(new Agent(i, "" + i));
		}
	}
	
	@Test
	public void ThreadsExecuted() {
		Thread t;
		
		for(Agent a: agents) {
			t = new Thread(a);
			t.start();
			Assert.assertTrue("Thread should be running", t.isAlive());
		}
	}
	
	@Test
	public void ThreadsScheduled() {
		// noop
		
	}
}