package com.program.Design.CreationalPattern;

// https://www.tutorialspoint.com/design_pattern/index.htm
// https://www.geeksforgeeks.org/software-design-patterns/

public class AbstractFactory {
	public static void main(String[] args) {
		CarType cartype = new CarType();
		Car car1 = cartype.getCar("BenQ");
		System.out.println(car1.getWheels());
		System.out.println(car1.getBody());
		System.out.println(car1.getEngine());
		System.out.println(car1.getMirrors());
		System.out.println();
		Car car2 = cartype.getCar("BMW");
		System.out.println(car2.getWheels());
		System.out.println(car2.getBody());
		System.out.println(car2.getEngine());
		System.out.println(car2.getMirrors());
	}
}

abstract class Car{
	public abstract Parts getWheels();
	public abstract Parts getMirrors();
	public abstract Parts getEngine();
	public abstract Parts getBody();
}

class Parts{
	public String specification;

	public Parts(String specification) {
		this.specification = specification;
	}

	public String getSpecification() {
		return this.specification;
	}
	
	@Override
	public String toString() {
		return this.specification;
	}
}

//Concrete BenQ Car (product)
class BenQ extends Car{
	@Override
	public Parts getWheels() {
		return new Parts("BenQ Wheels");
	}

	@Override
	public Parts getMirrors() {
		return new Parts("BenQ Mirrors");
	}

	@Override
	public Parts getEngine() {
		return new Parts("BenQ Engine");
	}

	@Override
	public Parts getBody() {
		return new Parts("BenQ Body");
	}	
}

//Concrete BMW Car (product)
class BMW extends Car{
	@Override
	public Parts getWheels() {
		return new Parts("BMW Wheels");
	}
	@Override
	public Parts getMirrors() {
		return new Parts("BMW Mirrors");
	}
	@Override
	public Parts getEngine() {
		return new Parts("BMW Engine");
	}
	@Override
	public Parts getBody() {
		return new Parts("BMW Body");
	}
}


//Abstract Factory
class CarType{
	private Car car= null;	
	public Car getCar(String carType) {
		if(carType.equals("BenQ")) {
			car =  new BenQ();
		}else if(carType.equals("BMW")) {
			car = new BMW();
		}
		return car;
	}
}