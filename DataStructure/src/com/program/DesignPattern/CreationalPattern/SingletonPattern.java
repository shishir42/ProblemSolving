package com.program.Design.CreationalPattern;
public final class SingletonPattern {
	public static void main(String[] args) {

	}
}

//Singleton pattern is used to when only one instance of an object is needed throughout the 
//lifetime of an application

//Singleton class is instantiated at the time of first access and the same instance is used thereafter till the application quits.


//Two Points:
//There should be only one instance allowed for a class
//We should allow global point of access to that single instance

//Easy Implementation: Work with single threaded environment 
//If we don't synchronize the method which is going to return the instance, there is a possibility of allowing multiple instances
// in a multi-threaded scenario.
//If two threads(Says T1 and T2) call getInstance() at the same time, two Singleton instance can be created
class SingletonUsingStaticReference{
	private static SingletonUsingStaticReference instance;
	private SingletonUsingStaticReference() {}
	public static SingletonUsingStaticReference getInstance() {
		if(instance == null) {
			instance = new SingletonUsingStaticReference();
		}
		
		return instance;
	}
}

//Thread Safe
//Problem with this solution is that it may be expensive.Each access to the singleton require acquisition of a lock
//but in reality, we need a lock only when initializing instance.
class SingletonUsingSynchronize{
	private static SingletonUsingSynchronize instance;
	private SingletonUsingSynchronize() {}
	public synchronized static SingletonUsingSynchronize getInstance() {
		if(instance == null) {
			instance = new SingletonUsingSynchronize();
		}
		return instance;
	}
}

//To solved above problem, we need the lock only for the first time. Synchronize only critical code
class SingletonUsingSynchronizeBlock{
	private static SingletonUsingSynchronizeBlock instance;
	private SingletonUsingSynchronizeBlock() {}
	public static SingletonUsingSynchronizeBlock getInstance() {
		if(instance == null) {
			synchronized (SingletonUsingSynchronizeBlock.class) {
				instance = new SingletonUsingSynchronizeBlock();
			}
		}
		return instance;
	}
}

//Double Checked Locking
//Above code is not thread safe
//Consider the following scenario: T1 enters the synchronized block, and before it can assign the singleton member variable, 
//the thread is preempted. Subsequently, another thread can enter the if block, The second thread will wait to finish for the first thread to finish.
//But we will still wind up with two distinct singleton instances.

class SingleUsingDoubleChecked{
	private static SingleUsingDoubleChecked instance;
	private SingleUsingDoubleChecked() {}
	public synchronized static SingleUsingDoubleChecked getInstance() {
		if(instance == null) {
			synchronized (SingleUsingDoubleChecked.class) {
				instance = new SingleUsingDoubleChecked();
			}
		}
		return instance;
	}
}


//Early and Lazy Instantiation 
class SingletonUsingLazy{
	private static SingletonUsingLazy instance = new SingletonUsingLazy();
	private SingletonUsingLazy(){}
	public static SingletonUsingLazy getInstance() {
		return instance;
	}
}

//In a large, complex program it may not be simple to discover where in the code a Singleton has been instantiated. In java,
//global variables does not really exist so we cant save these Singletons in a single place

//One solution is to create such singletons at the beginning of the program and pass them as arguments to the major
//classes that might need to use them

//instance = Singleton.getInstance();
//Processor p = new Processor(instance);

//It can be difficult to subclass a singleton, since this works only if the base singleton class has not yet been instantiated.
//We can easily change a Singleton to allow a small number of instances where this is allowable and meaningful.