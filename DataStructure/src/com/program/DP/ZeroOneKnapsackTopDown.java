package com.program.DP;

public class ZeroOneKnapsackTopDown {
    public static void main(String[] args){
        ZeroOneKnapsackTopDownSol ks = new ZeroOneKnapsackTopDownSol();
		int[] profits = { 31, 26, 72, 17 };
		int[] weights = { 3, 1, 5, 2 };
		int maxProfit = ks.knapSack(profits, weights, 7);
		System.out.println(maxProfit);
    }
}

class ZeroOneKnapsackTopDownSol{
    public int knapSack(int[] profits, int[] weights, int capacity){
        Integer[][] dp = new Integer[profits.length][capacity + 1];
        return knapSackAux(dp, profits, weights, capacity, 0);
    }

    private int knapSackAux(Integer[][] dp, int[] profits, int[] weights, int capacity, int currentIndex){
        if(capacity <=0 || currentIndex < 0 || currentIndex >= profits.length){ //Base case
            return 0;
        }

        if (dp[currentIndex][capacity] != null) // if we have already solved this problem, then return the result from memory 
			return dp[currentIndex][capacity];

		int profit1 = 0;
		if (weights[currentIndex] <= capacity) // Taking current element
			profit1 = profits[currentIndex]  + knapSackAux(dp, profits, weights, capacity - weights[currentIndex], currentIndex + 1);

		int profit2 = knapSackAux(dp, profits, weights, capacity, currentIndex + 1); // Not taking current element
		dp[currentIndex][capacity] = Math.max(profit1, profit2);
		return dp[currentIndex][capacity];
    }
}
