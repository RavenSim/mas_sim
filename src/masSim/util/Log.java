package masSim.util;

import java.util.logging.Logger;

public class Log {
	private static Logger log;
	
	public static Logger getLogger() {
		if(log == null) {
			log = Logger.getLogger("masSim");
		}
		
		return log;
	}

}
