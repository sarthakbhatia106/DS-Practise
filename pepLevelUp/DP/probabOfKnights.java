package DP;

import java.util.*;

public class probabOfKnights {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int x = scn.nextInt();
        int y = scn.nextInt();
        int k = scn.nextInt();
        double ans = findProb(n, x, y, k);
        System.out.println(ans);
        scn.close();
    }

    public static double findProb(int N, int start_x, int start_y, int step) {
        double[][] prev = new double[N][N];
        double[][] cur = new double[N][N];
        int [][]dir={{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2}};
        prev[start_x][start_y]=1;

        while(step-->0){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(prev[i][j]>0){
                        for(int k=0;k<dir.length;k++){
                            int nrow=i+dir[k][0];
                            int ncol=j+dir[k][1];
                            if(nrow>=0 && nrow<N && ncol>=0 && ncol<N){
                                cur[nrow][ncol]+=prev[i][j]/(1.0*8);
                            }
                        }
                    }
                }
            }
            prev=cur;
            cur=new double[N][N];
        }
        double ans=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                ans+=prev[i][j];
                // System.out.print(prev[i][j]+" ");
            }
            // System.out.println();
        }
        return ans;
    }
}
