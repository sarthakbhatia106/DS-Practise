class Solution {
    public int stoneGameVII(int[] stones) {
        
        int n=stones.length;
        int []sum=new int[n];

        sum[0]=stones[0];
        for(int i=1;i<n;i++){
            sum[i]=sum[i-1]+stones[i];
        }

        int [][]dp=new int[n][n];

        for(int gap=0;gap<n;gap++){
            for(int left=0,right=gap;right<n;left++,right++){

                int a=left+2<=right?dp[left+2][right]:0;
                int b=right-2>=left?dp[left][right-2]:0;
                int c=(left+1<=right && right-1>=left)?dp[left+1][right-1]:0;

                int s=sum[right]-(left-1>=0?sum[left-1]:0);
                int one=s-stones[left]+Math.min(a,c);
                int two=s-stones[right]+Math.min(b,c);

                dp[left][right]=Math.max(one,two);
            }
        }
        return 2*dp[0][n-1]-sum[n-1];
    }
}