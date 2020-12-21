package com.program.Design.StructuralPattern;

// It is used to extend or modify the behaviour of an instance at runtime. 
//Inheritance can be used to extend the abilities of a class (for all instances of class)
//Inheritance adds functionality to classes, whereas rhe decorator pattern adds functionality to objects by wrapping objects in other objects

//Example: House is a classic example for decorator design pattern. We create a basic House and then add decoration like colors, 
//lights etc


public class DecoratorDesignPattern {
	public static void main(String[] args) {
		House house = new LightsDecortor(new ColorDecorator(new SimpleHouse()));
		System.out.println(house.makeHouse());
	}
}

interface House{
	public String makeHouse();
}

class SimpleHouse implements House{
	public String makeHouse() {
		return "Base House";
	}	
}

abstract class HouseDecorator implements House{
	protected House house;
	public HouseDecorator(House house) {
		this.house = house;
	}
	
	public String makeHouse() {
		return this.house.makeHouse();
	}
}

class ColorDecorator extends HouseDecorator{
	public ColorDecorator(House house) {
		super(house);
	}
	
	private String addColors() {
		return " Colors";
	}
	
	public String makeHouse() {
		return this.house.makeHouse() + this.addColors();
	}
}

class LightsDecortor extends HouseDecorator{
	public LightsDecortor(House house) {
		super(house);
	}
	
	private String addLights() {
		return " Lights";
	}
	
	public String makeHouse() {
		return this.house.makeHouse() + this.addLights();
	}
}