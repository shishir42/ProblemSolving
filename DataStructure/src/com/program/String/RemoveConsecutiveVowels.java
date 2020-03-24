package com.program.String;

public class RemoveConsecutiveVowels {

	public static void main(String[] args) {
		String str = "geeks for geeks"; 
		new RemoveConsecutiveVowelsTest().removeConsecutiveVowel(str);
	}
}

class RemoveConsecutiveVowelsTest
{
	public boolean isVowel(char c)
	{
		return (c=='a') || (c=='e') || (c=='i') || (c=='o') || (c=='u');
	}
	
	public void removeConsecutiveVowel(String str)
	{
		System.out.print(str.charAt(0));
		
		for (int i = 1; i < str.length(); i++) {
			if((!this.isVowel(str.charAt(i-1))) || (!this.isVowel(str.charAt(i))))
			{
				System.out.print(str.charAt(i));
			}
		}
	}
}