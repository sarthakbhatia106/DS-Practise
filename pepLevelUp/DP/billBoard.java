package DP;

import java.util.Scanner;
public class billBoard{
    public static int solution(int m , int[] x, int[] rev, int t) {
        int []arr=new int[m+1];
        int idx=0;
        
        for(int i=1;i<arr.length;i++){
            if(idx<x.length && i==x[idx]){
                int a=rev[idx]+((i-t-1<0)?0:arr[i-t-1]);
                arr[i]=Math.max(a,arr[i-1]);
                idx++;
            }else{
                arr[i]=arr[i-1];
            }
        }
        
        return arr[m];
    }
    public static int solution1(int m,int []x,int []rev,int t){
        int ans=0;
        int []dp=new int[x.length];

        for(int i=0;i<x.length;i++){
            int max=0;
            for(int j=i-1;j>=0;j--){
                if(x[i]-x[j]>t){
                    max=Math.max(max, dp[j]);
                }
            }
            dp[i]=max+rev[i];
            ans=Math.max(ans, dp[i]);
        }
        return ans;

    }
    public static void input(int []arr,Scanner scn){
        for(int i = 0;i<arr.length;i++){
            arr[i] = scn.nextInt();
        }
    }
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);   
        int m = scn.nextInt();
        int n = scn.nextInt();
        
        int x[] = new int[n];
        input(x, scn);

        int revenue[] = new int[n];
        input(revenue,scn);

        int t = scn.nextInt();

        // System.out.println(solution(m, x, revenue, t));
        System.out.println(solution1(m, x, revenue, t));
        scn.close();
    }
}