package com.program.Design;

public class FactoryMethodDesign {
	public static void main(String[] args) {
		PetFactory petFactory = new PetFactory();
		Pet pet1 = petFactory.getPet("Bow");
		System.out.println(pet1.petSound());
		
		Pet pet2 = petFactory.getPet("Meaw");
		System.out.println(pet2.petSound());
	}
}
interface Pet{
	public String petSound();
}
//Derived class1 that might get instantiated by a factory method pattern
//Dog Concrete Product class
class Dog implements Pet{
	@Override
	public String petSound() {
		return "Dog: Bow Bow..";
	}
}
//Derived class2 that might get instantiated by a factory method pattern
//Cat Concrete Product class
class Cat implements Pet{
	@Override
	public String petSound() {
		return "Cat: Meaw Meaw..";
	}
}
//Factory Method pattern implementation that instantiates object based on logic
class PetFactory{
	public Pet getPet(String petType){
		Pet pet = null;
		//based on logic factory instantiates an object
		if("Bow".equals(petType)) {
			pet = new Dog();
		}else if("Meaw".equals(petType)) {
			pet = new Cat();
		}		
		return pet;
	}
}
