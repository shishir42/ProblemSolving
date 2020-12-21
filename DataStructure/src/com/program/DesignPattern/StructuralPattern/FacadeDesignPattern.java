package com.program.Design.StructuralPattern;


//Hides the complexities of the system and provides a simple interface
// to the client from where client can access the system

//In Java, the interface JDBC is an example of facade pattern 



public class FacadeDesignPattern {
	public static void main(String[] args) {
		MyGUI facade = new MyGUI();
		facade.drawGUI();
	}
}

class GUIMenu{
	public void drawMenuButtons() {}
}

class GUITitleBar{
	public void showTitleBar(String caption) {
		System.out.println(caption);
	}
}

class GUIContent{
	public void showButtons() {}
	public void showTextFields() {}
	public void setDefaultValues() {}
}

class MyGUI{
	private GUIMenu menu;
	private GUITitleBar titleBar;
	private GUIContent content;
	
	public MyGUI() {
		this.menu = new GUIMenu();
		this.titleBar = new GUITitleBar();
		this.content = new GUIContent();
	}
	
	public void drawGUI() {
		this.content.showButtons();
		this.content.showTextFields();
		this.content.setDefaultValues();
		this.menu.drawMenuButtons();
		this.titleBar.showTitleBar("Title of GUI");
	}
}
