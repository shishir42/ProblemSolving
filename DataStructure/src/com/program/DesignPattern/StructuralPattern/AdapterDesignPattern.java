package com.program.Design.StructuralPattern;

//Example: problem with power sockets of 2 pin and 3 pin. If we have a 3 - pin plug and a 2 pin 
// power socket, then we use an intermediate adapter and fit the 3-pin cable to it and attached the adapter to 2 pin power socket

// Consider the case of having a class or module we need to use in our application. 
//Assume it is poorly coded and it would pollute our nicely designed code. But there's no other way, 
//we need its functionality and don't have time to write it from scratch. 

// The best practice is to write our own adapter and wrap old code inside of it. Then we can use our own interface and therefore 
// reduce our dependency on the old ugly code.

// Adapter pattern converts the existing interface to a new interface to achieve compatibility and reusability of the unrelated 
// classes in one Application. Adapter pattern is also know as Wrapper pattern. An adapter allows classes to work together 
// that normally could not because of incompatible interfaces

// Adapter is also responsible for transforming data into appropriate forms. When a client specifies its requirement in an interface, 
// we can usually create a new class that implements the interface and subclasses an existing class. This approavh creates a class
// adapter that translates a clent's calls into calls to the existing class's methods

// Two ways of implementing Adapter pattern:
// Using inheritance [class adapters]
// Using composition [object adapters]


// Main use of this pattern is when a class that you need to use doesn't meet the requirements of an interface
// Adapters are common across Eclipse plug-ins

//Drawbacks : due to the additional layer of code added, and so to maintain. But if rewriting existing code is not an option, 
// adapters provide a good options

public class AdapterDesignPattern {
	public static void main(String[] args) {
		// Adapter Implementation using inheritance 
		Client c1 = new Client();
		c1.functionTest();
		
		// Adapter implementation Using Composition 
		ClientComposition c2 = new ClientComposition();
		c2.functionTest();
	}
}

// Adapter Implementation using inheritance 

//Adaptee
class Plug{
	private String specification;
	public String getInput(){
		return this.specification;
	}
	
	public Plug() {
		this.specification = "3-Pin";
	}
}

//Target
interface Socket{
	public String getInput(); //expects power to 2-Pin
}

class ExpansionAdapter extends Plug implements Socket{
	@Override
	public String getInput() {
		String input = super.getInput(); // calling base class getInput
		input = input + " Power converted to 2-Pin";
		return input;
	}	
}

// Observe that, getInput() of ExpansionAdapter converts the 3-pin (input from Plug)
// power to 2-pin (input to Socket) power
class Client{
	private Socket socket;
	
	public void functionTest() {
		socket = new ExpansionAdapter();
		System.out.println(socket.getInput());
	}
}

// Adapter implementation Using Composition // it enable the usage of tools like dependency injection
class ExpansionAdapterComposition implements Socket{

	//Plug object is now part of Adapter
	private Plug plug;
	
	public ExpansionAdapterComposition(Plug plug) {
		this.plug = plug;
	}
	
	@Override
	public String getInput() {
		String input = plug.getInput();
		input = input + " power converted to 2-pin";
		return input;
	}
}

class ClientComposition{
	private Socket socket;
	public void functionTest() {
		socket = new ExpansionAdapterComposition(new Plug());
		System.out.println(socket.getInput());
	}
}


