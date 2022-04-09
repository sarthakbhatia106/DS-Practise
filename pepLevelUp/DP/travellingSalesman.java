package DP;

import java.util.*;
public class travellingSalesman {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);

        int n=scn.nextInt();
        int [][]cost=new int[n][n];

        for(int i=0;i<n;i++){
            for(int mask=0;mask<n;mask++){
                cost[i][mask]=scn.nextInt();
            }
        }

        Integer [][]dp=new Integer[21][(1<<21)];
        System.out.println(findOptimalCost(cost,0,((1<<n)-1)^1,dp));
    }

    private static int findOptimalCost(int[][] cost, int i, int mask, Integer[][] dp) {
        if(mask==0){
            return cost[i][0];
        }

        if(dp[i][mask]!=null){
            return dp[i][mask];
        }

        int ans=Integer.MAX_VALUE;
        for(int j=1;j<cost.length;j++){
            if((mask&(1<<j))!=0){
                ans=Math.min(ans,cost[i][j]+findOptimalCost(cost,j,(mask^(1<<j)),dp));
            }
        }
        return dp[i][mask]=ans;
    }
}
