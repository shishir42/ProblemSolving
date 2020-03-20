package com.program.Math;

public class PowerCalculation {

	public static void main(String[] args) {
		Power pow = new Power();
		int value = pow.calPower(2, 2);
		System.out.println("Value using recursion " + value);
		
		System.out.println("Value using recursion " + pow.calPowerRecursion(2, 3));
		System.out.println("Value using recursion " + pow.calPowserRecursion1(2, 3));
	}

}

class Power{
	public int calPower(int x, int y)
	{
		//System.out.println(x + " " + y);
		if(y == 0)
		{
			return 1;
		}
		else if(y % 2 == 0)
		{
			return calPower(x, y/2) * calPower(x, y/2);
		}
		else
		{
			return x * calPower(x, y/2) * calPower(x, y/2);
		}
	}
	
	//Time Complexity: O(n)
	//Space Complexity: O(1)
	//Algorithmic Paradigm: Divide and conquer
	
	public int calPowerRecursion(int x, int y)
	{
		if(y == 0)
		{
			return 1;
		}
		else
		{
			return x * calPowerRecursion(x, y-1);
		}		
	}
	
	//Time complexity: O(n)
	
	public int calPowserRecursion1(int x, int y)
	{
		if(y == 0)
		{
			return 1;
		}
		else if(y % 2 == 0)
		{
			y = calPowserRecursion1(x, y/2);
			return y * y;
		}
		else
		{
			return x * calPowserRecursion1(x, y - 1);
		}
	}
	
	//Time complexity: Olog(n)
}











