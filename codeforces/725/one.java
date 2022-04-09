import java.io.*;
import java.util.*;

public class one {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            int n=Integer.parseInt(br.readLine());
            String []str=br.readLine().split(" ");

            int []arr=new int[n];
            int min=Integer.MAX_VALUE;
            int max=Integer.MIN_VALUE;
            int minIdx=-1;
            int maxIdx=-1;
            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(str[i]);
                if(arr[i]>max){
                    max=arr[i];
                    maxIdx=i;
                }

                if(arr[i]<min){
                    min=arr[i];
                    minIdx=i;
                }
            }
            minIdx++;
            maxIdx++;
            int ans=Math.max(minIdx, maxIdx);
            ans=Math.min(ans,Math.max(n-maxIdx+1, n-minIdx+1));
            ans=Math.min(ans, minIdx+(n-maxIdx+1));
            ans=Math.min(ans,n-minIdx+1+maxIdx);
            System.out.println(ans);
        }
    }    
}
