import java.io.*;
import java.util.*;

public class two {
    public static void main(String[] args) throws IOException {
        Scanner scn=new Scanner(System.in);
        int t=scn.nextInt();
        StringBuilder sb=new StringBuilder();
        while(t-->0){
            int n=scn.nextInt();

            long []arr=new long[n];
            for(int i=0;i<n;i++){
                arr[i]=scn.nextLong();
            }

            if(n<=1){
                System.out.println(n);
            }
            else{
                Arrays.sort(arr);
    
                int size=n-1;
                long []diff=new long[size];
                for(int i=0;i<size;i++){
                    diff[i]=arr[i+1]-arr[i];
                }
    
                long []maxDiff=new long[size];
                maxDiff[0]=diff[0];
                for(int i=1;i<size;i++){
                    maxDiff[i]=Math.min(maxDiff[i-1],diff[i]);
                }
    
                int ans=1;
                for(int i=1;i<n;i++){
                    if(maxDiff[i-1]<arr[i]){
                        break;
                    }else{
                        ans++;
                    }
                }
                System.out.println(ans);
            }
        }
    }    
}
