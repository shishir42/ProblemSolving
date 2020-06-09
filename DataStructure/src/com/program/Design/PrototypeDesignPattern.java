package com.program.Design;

import java.util.Hashtable;

public class PrototypeDesignPattern {
	public static void main(String[] args) {
		ShapeCache.loadCache();

		Shape clonedShape = (Shape)ShapeCache.getShape("1");
		System.out.println("Shape : " + clonedShape.getType());		

		Shape clonedShape2 = (Shape) ShapeCache.getShape("2");
		System.out.println("Shape : " + clonedShape2.getType());		

		Shape clonedShape3 = (Shape) ShapeCache.getShape("3");
		System.out.println("Shape : " + clonedShape3.getType());	
	}
}


// Creation of object is time consuming and costly affair
//If we already have a most similar object instance in hand, then go for prototype pattern
//Instead of going through time consuming process to create a complex object, just copy the existing similiar object and 
// modify it according to our need
//Prototype means making a clone. Cloning is the operation of replicating an object.
//Cloned object, the copy, is initialized with the current state of the object which clone was invoked.
//This implies cloning of an object avoids creation.

//Cloning of object is based on the concepts of shallow and copying

abstract class Shape implements Cloneable{
	private String id;
	protected String type;
	abstract void draw();

	public String getType() {
		return this.type;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Object clone() {
		Object clone = null;
		try {
			clone = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return clone;
	}
}

class Rectangle extends Shape{
	public Rectangle() {
		this.type = "Rectangle";
	}

	@Override
	void draw() {
		System.out.println("Inside Rectangle::draw() method.");
	}
}

class Square extends Shape{
	public Square() {
		this.type = "Square";
	}

	@Override
	void draw() {
		System.out.println("Inside Square::draw() method.");
	}
}

class Circle extends Shape{
	public Circle() {
		this.type = "Circle";
	}

	@Override
	void draw() {
		System.out.println("Inside Circle::draw() method.");		
	}
}

class ShapeCache{
	private static Hashtable<String, Shape> shapeMap = new Hashtable<String, Shape>();

	public static Shape getShape(String shapeId) {
		Shape cachedShape = shapeMap.get(shapeId);
		return (Shape)cachedShape.clone();
	}

	// for each shape run database query and create shape
	// shapeMap.put(shapeKey, shape);
	// for example, we are adding three shapes

	public static void loadCache() {
		Circle circle = new Circle();
		circle.setId("1");
		shapeMap.put(circle.getId(),circle);

		Square square = new Square();
		square.setId("2");
		shapeMap.put(square.getId(),square);

		Rectangle rectangle = new Rectangle();
		rectangle.setId("3");
		shapeMap.put(rectangle.getId(), rectangle);
	}
}


