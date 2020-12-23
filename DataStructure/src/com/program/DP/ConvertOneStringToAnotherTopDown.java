package com.program.DP;

public class ConvertOneStringToAnotherTopDown{
    public static void main(String[] args){
        ConvertOneStringSolution sol = new ConvertOneStringSolution();
        System.out.println(sol.findMinOperations("table", "tbres"));
    }
}

class ConvertOneStringSolution{
    public int findMinOperations(String s1, String s2){
        Integer[][] dp = new Integer[s1.length() + 1][s2.length()+1];
        return findMinOpeationsRecursive(dp, s1, s2, 0, 0);
    }

    private int findMinOpeationsRecursive(Integer[][] dp, String s1, String s2, int l1, int l2){
        if(dp[l1][l2] == null){
            if(l1 == s1.length()) // if we have reached the end of s1, then insert all the remaining characters of s2
	        dp[l1][l2] = s2.length() - l2;
	     
	      else if(l2 == s2.length()) // if we have reached the end of s2, then delete all the remaining characters of s1
	        dp[l1][l2] = s1.length() - l1;
	      
	      else if(s1.charAt(l1) == s2.charAt(l2)) // If the strings have a matching character, recursively match for the remaining lengths.
	        dp[l1][l2] = findMinOpeationsRecursive(dp, s1, s2, l1+1, l2+1);
	  
	      else {
	        int c1 = findMinOpeationsRecursive(dp, s1, s2, l1+1, l2); //delete
	        int c2 = findMinOpeationsRecursive(dp, s1, s2, l1, l2+1); //insert
	        int c3 = findMinOpeationsRecursive(dp, s1, s2, l1+1, l2+1); //replace
	        dp[l1][l2] = 1 + Math.min(c1, Math.min(c2, c3));
	      }
	    }//end of if-else        

        return dp[l1][l2];
    }
}