import java.io.*;
import java.util.*;

public class four {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            int n=Integer.parseInt(br.readLine());
            String []str=br.readLine().split(" ");

            int []arr=new int[n+1];
            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(str[i]);
            }

            HashMap<Integer,Long>map=new HashMap<>();
            long ans=0;

            for(int i=n-1;i>=0;i--){
                ans+=(i+1)*map.getOrDefault(arr[i], 0L);

                map.put(arr[i], map.getOrDefault(arr[i],0L)+n-i);
            }
            System.out.println(ans);
        }
    }
}
