package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo {
	
	private static Logger logger = LogManager.getLogger(Log4jDemo.class);
	
	public static void main(String[] args) {
		
		System.out.println("\n Hello. World..!\n");
		
		logger.trace("This is trace msg");
		logger.info("This is info msg");
		logger.error("This is error msg");
		logger.warn("This warning msg");
		logger.fatal("This fatal msg");
		
		System.out.println("\n Completed");
		
	}
	

}
