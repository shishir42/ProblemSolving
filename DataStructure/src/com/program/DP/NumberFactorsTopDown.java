package com.program.DP;

public  class NumberFactorsTopDown{
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(" " + sol.waysToGetN(4));
        System.out.println(" " + sol.waysToGetN(5));
        System.out.println(" " + sol.waysToGetN(6));
    }    
}

class Solution{
    public int waysToGetN(int n){
        int [] dp = new int[n +1];
        return waysToGetNTopDown(dp, n);
    }

    public int waysToGetNTopDown(int[] dp, int n){
        if((n == 0) || (n == 1) || (n ==2)){
            return 1;
        }

        if(n == 3){
            return 2;
        }

        if(dp[n] == 0){
            int sub1 = waysToGetNTopDown(dp, n-1);
            int sub3 = waysToGetNTopDown(dp, n-3);
            int sub4 = waysToGetNTopDown(dp, n-4);

            dp[n] = sub1 + sub3 + sub4;
        }

        return dp[n];
    }
}
