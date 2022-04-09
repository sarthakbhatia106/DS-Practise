import java.io.*;
import java.util.*;

public class two {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n=Integer.parseInt(br.readLine());
            String []str=br.readLine().split(" ");

            int []arr=new int[n];
            int sum=0;
            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(str[i]);
                sum+=arr[i];
            }
            // Arrays.sort(arr);
            
            if(sum%n!=0){
                System.out.println(-1);
            }
            else{
                int s=sum/n;
                int ans=0;
                for(int i=0;i<n;i++){
                    if(arr[i]>s){
                        ans++;
                    }
                }
                System.out.println(ans);
            }
        }
    }
}
