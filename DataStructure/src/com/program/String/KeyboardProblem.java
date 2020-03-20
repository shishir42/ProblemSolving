package com.program.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class KeyboardProblem {

	public static void main(String[] args) {
		Solution sol = new Solution();
		String[] arr  = new String[] {"Hello", "Alaska", "Dad", "Peace"};
		String[] result = sol.findWords(arr);
		System.out.println(Arrays.toString(result));
	}
}

class Solution
{
	public String[] findWords(String[] words)
	{
		Set<Character> line0 = stringtoSet("qwertyuiop");
		Set<Character> line1 = stringtoSet("asdfghjkl");
		Set<Character> line2 = stringtoSet("zxcvbnm");
		ArrayList<String> ans = new ArrayList<String>();
		
		for (String word : words) {
			Set<Character> temp = stringtoSet(word.toLowerCase());
			if(line0.containsAll(temp) || line1.containsAll(temp) || line2.containsAll(temp))
			{
				ans.add(word);
			}
		}
		
		return ans.toArray(new String[ans.size()]);
	}
	
	public Set<Character> stringtoSet(String word)
	{
		Set<Character> res = new HashSet<Character>();
		for (Character character : word.toCharArray()) {
			res.add(character);
		}		
		return res;
	}
}
