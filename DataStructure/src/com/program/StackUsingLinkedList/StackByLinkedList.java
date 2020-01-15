package com.program.StackUsingLinkedList;

import com.program.Singlelinkedlist.SingleLinkedList;

///Stacks Application
//1.Stack of plates in a buffet table
//2.Stack of Moulded chairs

//3.A good real-life example of a stack is the pile of dinner plates that you encounter when you eat at the local cafeteria: 
//When you remove a plate from the pile, you take the plate on the top of the pile. 
//But this is exactly the plate that was added ("inserted'') most recently to the pile by the dishwasher. 
//If you want the plate at the bottom of the pile, you must remove all the plates on top of it to reach it.

//Stack (LIFO): The tennis balls in their container.. (you cannot remove 2 balls at the same time)
//To reverse a word. You push a given word to stack - letter by letter - and then pop letters from the stack.
//An "undo" mechanism in text editors; this operation is accomplished by keeping all text changes in a stack.Undo/Redo stacks in Excel or Word.
//Language processing :space for parameters and local variables is created internally using a stack.
//compiler's syntax check for matching braces is implemented by using stack.

//Expression Evaluation:Stack is used to evaluate prefix, postfix and infix expressions.
//Expression Conversion:An expression can be represented in prefix, postfix or infix notation. Stack can be used to convert one form of expression to another.
//Syntax Parsing:Many compilers use a stack for parsing the syntax of expressions, program blocks etc. before translating into low level code.
//Backtracking:Suppose we are finding a path for solving maze problem. We choose a path and after following it we realize that it is wrong. Now we need to go back to the beginning of the path to start with new path. This can be done with the help of stack.
//Parenthesis Checking:Stack is used to check the proper opening and closing of parenthesis.
//String Reversal:Stack is used to reverse a string. We push the characters of string one by one into stack and then pop character from stack.
//Function Call:Stack is used to keep information about the active functions or subroutines.



//The Stack is Last In First Out (LIFO) data structure. This data structure has some important applications in different aspect. These are like below −

//1.Expression Handling −
//Infix to Postfix or Infix to Prefix Conversion −

//The stack can be used to convert some infix expression into its postfix equivalent, or prefix equivalent. These postfix or prefix notations are used in computers to express some expressions. These expressions are not so much familiar to the infix expression, but they have some great advantages also. We do not need to maintain operator ordering, and parenthesis.

//Postfix or Prefix Evaluation −

//After converting into prefix or postfix notations, we have to evaluate the expression to get the result. For that purpose, also we need the help of stack data structure.

//2.Backtracking Procedure −

//Backtracking is one of the algorithm designing technique. For that purpose, we dive into some way, if that way is not efficient, we come back to the previous state and go into some other paths. To get back from current state, we need to store the previous state. For that purpose, we need stack. Some examples of backtracking is finding the solution for Knight Tour problem or N-Queen Problem etc.

//3.Another great use of stack is during the function call and return process. When we call a function from one other function, that function call statement may not be the first statement. After calling the function, we also have to come back from the function area to the place, where we have left our control. So we want to resume our task, not restart. For that reason, we store the address of the program counter into the stack, then go to the function body to execute it. After completion of the execution, it pops out the address from stack and assign it into the program counter to resume the task again.




///https://lifeindatastructures.wordpress.com/2017/10/05/applications-of-stacks/
//https://www.tutorialride.com/data-structures/applications-of-stack-in-data-structure.htm
//http://jcsites.juniata.edu/faculty/kruse/cs240/stackapps.htm

public class StackByLinkedList {
	private SingleLinkedList list;
	
	public StackByLinkedList() {
		this.list = new SingleLinkedList();
	}
	
	public void push(int nodeValue) {
		//create a node
		//node.value = nodeValue
		//node.next = head
		//head = node
		
		if(this.list.getHead() == null) {
			this.list.createSingleLinkedList(nodeValue);
		}else {
			this.list.insertInLinkedList(nodeValue, 0);
		}
		System.out.println("Inserted " + nodeValue + " in Stack !");
	}
	
	public int pop() {
		//isEmpty return error message
		//tempNode = head
		//head = head.next;
		//return tempNode.value
		int value = -1;
		if(this.isEmptyStack()) {
			System.out.println("Stack underflow error...");
		}else {
			value = this.list.getHead().getValue();
			list.deletionOfNode(0);
		}		
		return value;
	}
	
	public boolean isEmptyStack() {
		if(this.list.getHead() == null) {
			return true;
		}
		return false;
	}
	
	public int peek() {
		int value = -1;
		if(this.isEmptyStack()) {
			System.out.println("Stack is empty...");
		}else {
			value = this.list.getHead().getValue();
		}		
		return value;
	}
	
	public void deleteStack() {
		list.setHead(null);
	}
}
