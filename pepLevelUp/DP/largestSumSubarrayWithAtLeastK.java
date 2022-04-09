package DP;

import java.util.*;

public class largestSumSubarrayWithAtLeastK {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int []arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
        int k=scn.nextInt();

        int []pre=new int[n];
        pre[0]=arr[0];

        for(int i=1;i<n;i++){
            pre[i]=Math.max(pre[i-1]+arr[i],arr[i]);
        }

        int sum=0;

        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        int ans=sum;
        for(int i=k;i<n;i++){
            sum+=arr[i]-arr[i-k];
            ans=Math.max(ans,sum);
            ans=Math.max(ans,sum+pre[i-k]);
        }
        System.out.println(ans);
        scn.close();
    }
}
