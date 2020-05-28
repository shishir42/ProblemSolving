package com.program.Design;

public class Builder {
	public static void main(String[] args) {
		CarBuilder lowPriceCarBuilder = new LowPriceCarBuilder();
		MechanicalEngineer engineer1 = new MechanicalEngineer(lowPriceCarBuilder);
		engineer1.buildCar();
		CarConcrete car1 = engineer1.getCar();
		System.out.println("Builder Constructed Low Price Car: " + car1);
		System.out.println();
		CarBuilder highPriceCarBuilder = new HighEndCarBuilder();
		MechanicalEngineer engineer2 = new MechanicalEngineer(highPriceCarBuilder);
		engineer2.buildCar();
		CarConcrete car2 = engineer2.getCar();
		System.out.println("Builder Constructed High Price Car: " + car2);
	}
}

//Used to constructs a complex object step by step and final step will return the object
//Process of constructing object should be generic so that it can be used to create different representation of the same object
//Purpose of builder pattern is to separate the construction of a complex object from its representation so that the same construction 
//process can create different representations
//Builder Pattern hides the internal details of how the product is built
//Each builder independent of others
//It will improves modularity and makes the builder of other builders easy 
//Each builder builds the final product step by step, we have more control on the final product
//In Java API, stringBuffer and stringBuilder are examples of builder patterns

interface CarPlan{
	public void setBase(String basement);
	public void setWheels(String structure);
	public void setEngine(String structure);
	public void setRoof(String structure);
	public void setMirrors(String roof);
	public void setLights(String lights);
	public void setInterior(String interior);
}

interface CarBuilder{
	public void buildBase();
	public void buildWheels();
	public void buildEngine();
	public void buildRoof();
	public void buildMirror();
	public void buildLight();
	public void buildInterior();
	public CarConcrete getCar();
}

class CarConcrete implements CarPlan{
	public String base;
	public String wheels;
	public String engine;
	public String roof;
	public String mirrors;
	public String lights;
	public String interior;
	
	@Override
	public void setBase(String basement) {
		this.base = basement;
	}

	@Override
	public void setWheels(String wheels) {
		this.wheels = wheels;
	}

	@Override
	public void setEngine(String engine) {
		this.engine = engine;
	}

	@Override
	public void setRoof(String roof) {		
		this.roof = roof;
	}

	@Override
	public void setMirrors(String mirrors) {
		this.mirrors = mirrors;
	}

	@Override
	public void setLights(String lights) {
		this.lights = lights;
	}

	@Override
	public void setInterior(String interior) {
		this.interior = interior;
	}	
	
	@Override
	public String toString() {
		return "\n" + this.base + "\n" + this.wheels + "\n" + this.engine + "\n" + this.roof + "\n" + this.mirrors + "\n" + this.lights + "\n" + this.interior;
	}
}

// Implementation of Builder (ConcreateBuilder)
class LowPriceCarBuilder implements CarBuilder{
	CarConcrete car = null;
	public LowPriceCarBuilder() {
		car = new CarConcrete();
	}
	
	@Override
	public void buildBase() {
		this.car.setBase("Low Price Base");		
	}

	@Override
	public void buildWheels() {
		this.car.setWheels("Low Price Wheel");
	}

	@Override
	public void buildEngine() {
		this.car.setEngine("Low Price Engine");
	}

	@Override
	public void buildRoof() {
		this.car.setRoof("Low Price Roof");
	}

	@Override
	public void buildMirror() {
		this.car.setMirrors("Low Price Mirror");
	}

	@Override
	public void buildLight() {
		this.car.setLights("Low Price Light");
	}

	@Override
	public void buildInterior() {
		this.car.setInterior("Low Price Interior");
	}

	@Override
	public CarConcrete getCar() {
		return this.car;
	}	
}

// Implementation of Builder (ConcreateBuilder)
class HighEndCarBuilder implements CarBuilder{
	private CarConcrete car;
	
	public HighEndCarBuilder() {
		this.car = new CarConcrete();
	}
	
	@Override
	public void buildBase() {
		this.car.setBase("High price Base");
	}

	@Override
	public void buildWheels() {
		this.car.setWheels("High price Wheels");
	}

	@Override
	public void buildEngine() {
		this.car.setEngine("High price Engine");
	}

	@Override
	public void buildRoof() {
		this.car.setRoof("High price Roof");
	}

	@Override
	public void buildMirror() {
		this.car.setMirrors("High price Mirror");		
	}

	@Override
	public void buildLight() {
		this.car.setLights("High price Light");		
	}

	@Override
	public void buildInterior() {
		this.car.setInterior("High price Interior");		
	}

	@Override
	public CarConcrete getCar() {
		return this.car;
	}
}

class MechanicalEngineer{
	private CarBuilder carBuilder;
	
	public MechanicalEngineer(CarBuilder carBuilder) {
		this.carBuilder = carBuilder;
	}
	
	public CarConcrete getCar() {
		return this.carBuilder.getCar();
	}
	
	public void buildCar() {
		this.carBuilder.buildBase();
		this.carBuilder.buildEngine();
		this.carBuilder.buildInterior();
		this.carBuilder.buildLight();
		this.carBuilder.buildMirror();
		this.carBuilder.buildRoof();
		this.carBuilder.buildWheels();
	}
}