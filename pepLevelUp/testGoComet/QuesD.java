package testGoComet;

import java.util.*;

public class QuesD {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        
        int n=scn.nextInt();
        int m=scn.nextInt();
        int [][]arr=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=scn.nextInt();
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==1){
                    dfs(arr,i,j);
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

    private static void dfs(int[][] arr, int i, int j) {
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || arr[i][j]==0){
            return;
        }

        arr[i][j]=0;
        dfs(arr, i-1, j);
        dfs(arr, i, j-1);
        dfs(arr, i, j+1);
        dfs(arr, i+1, j);
    }    
}
