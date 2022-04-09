import java.io.*;

public class three {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] str = br.readLine().split(" ");
            int x1 = Integer.parseInt(str[0]) - 1;
            int y1 = Integer.parseInt(str[1]) - 1;
            int x2 = Integer.parseInt(str[2]) - 1;
            int y2 = Integer.parseInt(str[3]) - 1;

            int n = Math.max(x1+1, Math.max(x2+1, Math.max(y1+1, y2+1)));
            n *= 2;
            // System.out.println(n);
            int arr[][] = new int[n][n];
            int count = 1;
            for (int i = 0; i < n; i++) {
                for (int sp = 0, ep = i; ep >= 0 && sp <=i; sp++, ep--) {
                    arr[sp][ep] = count++;
                }
            }

            System.out.println(solve(arr, x1, y1, x2, y2));
        }
    }
    public static int maxPathSum(int[][] grid,int ri,int ci,int rj,int cj) {
        
        int n=rj+1;
        int m=cj+1;
        int [][]dp=new int[n][m];
        
        
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i==n-1 && j==m-1){
                    dp[i][j]=grid[i][j];
                }else if(i==n-1){
                    dp[i][j]=dp[i][j+1]+grid[i][j];
                }else if(j==m-1){
                    dp[i][j]=dp[i+1][j]+grid[i][j];
                }else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j+1])+grid[i][j];
                }
            }
        }
        return dp[ri][ci];
    }
    public static int solve(int [][]arr,int ri,int ci,int rj,int cj){
        int ans=0;
        while(ri<=rj){
            ans+=arr[ri][ci];
            ri++;
        }
        ri--;
        ci++;
        while(ci<=cj){
            ans+=arr[ri][ci];
            ci++;
        }
        return ans;
    }
}
