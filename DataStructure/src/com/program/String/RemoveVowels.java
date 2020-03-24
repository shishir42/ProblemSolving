package com.program.String;

import java.util.Arrays;
import java.util.List;

public class RemoveVowels {
	public static void main(String[] args) {
		String str = "GeeeksforGeeks - A Computer Science Portal for Geeks"; 
        
        System.out.println(new Test().removeVowel(str)); 
	}
}

class Test
{
	public String removeVowel(String str)
	{
		StringBuffer sb = new StringBuffer(str);
		Character vowels[] = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
		List<Character>  al = Arrays.asList(vowels);
		for (int i = 0; i < sb.length(); i++) {
			if(al.contains(sb.charAt(i))) {
				sb.replace(i, i+1, "");
				i--;
			}
		}
		return sb.toString();
	}
}