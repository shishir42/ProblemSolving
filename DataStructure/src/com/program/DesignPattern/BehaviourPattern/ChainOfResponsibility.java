package com.program.DesignPattern.BehaviourPattern;

abstract class AbstractLogger{
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    protected int level;

    //next element in chain or responsibility
    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger logger){
        this.nextLogger  = logger;
    }

    abstract protected void write(String message);

    public void logMessage(int level, String message){
        if(this.level <= level){
            this.write(message);
        }

        if(this.nextLogger != null){
            nextLogger.logMessage(level, message);
        }
    }
}

class ConsoleLogger extends AbstractLogger{
    public ConsoleLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Console::Logger " + message);
    }
}

class FileLogger extends AbstractLogger{
    public FileLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger " + message);
    }
}

class ErrorLogger extends AbstractLogger{
    public ErrorLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error::Logger " + message);
    }
}


public class ChainOfResponsibility {

    private static AbstractLogger getChainOfLogger(){
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLogger();

        loggerChain.logMessage(AbstractLogger.INFO, "This is an information.");
        loggerChain.logMessage(AbstractLogger.DEBUG, "This is an debug level information.");
        loggerChain.logMessage(AbstractLogger.ERROR, "This is an error information.");        
    }
}

//https://sourcemaking.com/design_patterns/chain_of_responsibility
//https://refactoring.guru/design-patterns/chain-of-responsibility

//The Chain of Responsibility pattern avoids coupling the sender
// of a request to the receiver by giving more than one object a chance to handle the request.
// ATM use the Chain of Responsibility in money giving mechanism.
