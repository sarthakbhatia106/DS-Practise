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
            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(str[i]);
            }

            Arrays.sort(arr);

            int count=1;
            int val=arr[0];
            int idx=1;
            while(idx<n && arr[idx]==val){
                idx++;
                count++;
            }
            System.out.println(n-count);
        }
    }    
}
