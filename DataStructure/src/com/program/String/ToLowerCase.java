package com.program.String;

public class ToLowerCase {

	public static void main(String[] args) {
		ToLowerCaseString res = new ToLowerCaseString();
		//System.out.println(res.toLowerCase("az"));
		System.out.println(res.toLowerCase("al&phaBET"));
		char character = 'Z';    
		int ascii = (int) character;
		System.out.println(ascii);
	}
}

class ToLowerCaseString
{
	//in ASCII, a capital letter and its lowercase is offset by 32. 
    //adding 32 to the character value will make it lowercase
    //A-Z has ASCII values of 65-90
	//a-z has ASCII values of 97-122
	public String toLowerCase(String str)
	{
		StringBuilder res = new StringBuilder(str);
		for (int i = 0; i < str.length(); i++) {
			int asciiVal = str.charAt(i);
			if(asciiVal >= 65 && asciiVal <= 90)
			{
				res.setCharAt(i, (char)(asciiVal + 32));
			}
			else
			{
				res.setCharAt(i, (char)(asciiVal));
			}
		}
		
		return res.toString();
	}
}