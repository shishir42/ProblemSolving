package com.program.DP;

public class NumberFactorsBottomUp {
    public static void main(String[] args) {
        SolWaysToGetN sol = new SolWaysToGetN();
        System.out.println(sol.waysToGetN(4));
        System.out.println(sol.waysToGetN(5));
        System.out.println(sol.waysToGetN(6));
    }
}

class SolWaysToGetN{
    public int waysToGetN(int n){
        int dp[] = new int[n +1];
        dp[0] = dp[1] = dp[2] = 1; //Base Case
        dp[3] = 2;

        for(int i = 4;i<= n; i++){
            dp[i] = dp[i-1] + dp[i-3] + dp[i-4];
        }
        return dp[n];
    }
}
