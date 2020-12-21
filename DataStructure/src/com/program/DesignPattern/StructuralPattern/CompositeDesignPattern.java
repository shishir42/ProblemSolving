package com.program.Design.StructuralPattern;

import java.util.ArrayList;
import java.util.List;

// Composite is a collection of objects and they may be either a composite or just primitive object.

// Arithmetic operation 
// File Operation

public class CompositeDesignPattern {
	public static void main(String[] args) {
		Directory one = new Directory("test1"), two = new Directory("test2"), three = new Directory("test3");
		LeafFile a = new LeafFile("a.txt"), b = new LeafFile("b.txt"), c = new LeafFile("c.txt");
		
		one.add(a);
		one.add(b);
		one.add(c);
		
		two.add(a);
		two.add(b);
		two.add(c);
		
		three.add(a);
		three.add(b);
		three.add(c);
		
		one.printName();
		two.printName();
		three.printName();
	}
}

interface FileComponent{
	public void printName();
}

class LeafFile implements FileComponent{
	private String fileName;
	public LeafFile(String name) {
		this.fileName = name;
	}

	@Override
	public void printName() {
		System.out.println("FileName " + this.fileName);
	}
}

class Directory implements FileComponent{
	private String fileName;
	private List<FileComponent> files = new ArrayList<FileComponent>();
	public Directory(String name) {
		this.fileName = name;
	}
	
	public void add(FileComponent file) {
		this.files.add(file);
	}
	
	@Override
	public void printName() {
		System.out.println("Directory " + this.fileName);
		
		for (int i = 0; i < this.files.size(); i++) {
			FileComponent obj = files.get(i);
			obj.printName();
		}
	}	
}