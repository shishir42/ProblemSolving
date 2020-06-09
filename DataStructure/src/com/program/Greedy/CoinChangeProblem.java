package com.program.Greedy;

import java.util.Arrays;

public class CoinChangeProblem {
	public static void main(String[] args) {
		int [] coins = {1, 2, 5, 10, 50, 100, 500,2000};
		int amount = 2758;
		System.out.println("Coins available: "+Arrays.toString(coins));
		System.out.println("Target amount: "+ amount);
		CoinChangeProblemMain sol = new CoinChangeProblemMain();
		sol.coinChangeImplementation(coins, amount);
	}
}

class CoinChangeProblemMain{
	public void coinChangeImplementation(int[] coins, int N) {
		Arrays.sort(coins);
		int index = coins.length-1;
		while(true) {
			int coinValue = coins[index];
			index--;
			int maxAmount = (N/coinValue);
			maxAmount = maxAmount * coinValue;
			if(maxAmount > 0) {
				System.out.println("Coin value: "+coinValue+ " taken count: "+(N/coinValue));
				N = N-maxAmount;
			}
			
			if(N == 0) {
				break;
			}
		}
	}
}