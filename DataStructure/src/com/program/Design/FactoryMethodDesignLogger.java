package com.program.Design;

public class FactoryMethodDesignLogger {
	public static void main(String[] args) {
		LoggerFactory factory = new LoggerFactory();
		AppLogger logger = factory.getLogger(1);
		logger.log("1");	
	}
}

interface AppLogger{
	public void log(String logMsg);
}

class FileLogger implements AppLogger{
	@Override
	public void log(String logMsg) {
		System.out.println("File Logger: " + logMsg);
	}
}

class DatabaseLogger implements AppLogger{
	@Override
	public void log(String logMsg) {
		System.out.println("Database Logger: " + logMsg);
	}	
}

class ConsoleLogger implements AppLogger{
	@Override
	public void log(String logMsg) {
		System.out.println("Console Logger: " + logMsg);
	}	
}

class LoggerFactory{
	public AppLogger getLogger(int value) {
		if(value == 1) {
			return new FileLogger();
		}
		else if(value == 2) {
			return new DatabaseLogger();
		}
		else if(value == 3) {
			return new ConsoleLogger();
		}
		
		return null;
	}
}