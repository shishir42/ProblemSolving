package com.program.DP;

public class HouseThiefTopDown {
    public static void main(String[] args) {
        HouseThiefSol sol = new HouseThiefSol();
        int[] HouseNetWorth = {6, 7, 1, 30, 8, 2, 4};
        System.out.println(sol.maxMoney(HouseNetWorth));

        HouseNetWorth = new int[] {20, 5, 1, 13, 6, 11, 40};
        System.out.println(sol.maxMoney(HouseNetWorth));
    }    
}

class HouseThiefSol{
    public int maxMoney(int[] houseNetWorth){
        int dp[] = new int[houseNetWorth.length];
        return maxMoneyTopDown(dp, houseNetWorth, 0);
    }

    private int maxMoneyTopDown(int[] dp, int[] houseNetWorth, int currentIndex){
        if(currentIndex >= houseNetWorth.length){
            return 0;
        }

        if(dp[currentIndex] == 0){
            int stealCurrent = houseNetWorth[currentIndex] + maxMoneyTopDown(dp, houseNetWorth, currentIndex + 2);
            int skipCurrent = maxMoneyTopDown(dp, houseNetWorth, currentIndex + 1);
            dp[currentIndex] = Math.max(stealCurrent, skipCurrent);
        }

        return dp[currentIndex];
    }
}
