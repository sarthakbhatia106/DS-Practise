import java.io.*;
import java.util.*;
public class four {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            int n=Integer.parseInt(br.readLine()); 
            String []str=br.readLine().split(" ");
            int []arr=new int[n];
            HashMap<Integer, Integer> map=new HashMap<>();
            long ans=0;
            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(str[i]);
                if(map.containsKey(arr[i]-i)){
                    ans+=map.get(arr[i]-i);
                    map.put(arr[i]-i, map.get(arr[i]-i)+1);
                }else{
                    map.put(arr[i]-i,1);
                }
            } 
            System.out.println(ans);
        }
    }
}
