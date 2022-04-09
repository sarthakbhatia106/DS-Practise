import java.io.*;
import java.util.*;
public class array {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String []str=br.readLine().split(" ");
        int n=Integer.parseInt(str[0]);
        int k=Integer.parseInt(str[1]);

        String []s=br.readLine().split(" ");
        int []arr=new int[n];
        HashSet<Integer> set=new HashSet<>();
        int []dist=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(s[i]);
            set.add(arr[i]);
            dist[i]=set.size();
            System.out.print(dist[i]);
        }
        System.out.println();

        int i=0;
        int j=0;

        int ansi=-1;
        int ansj=-1;
        // int min=Integer.MAX_VALUE;

        while(j<n){
            int distance=0;
            if(i==0){
                distance=dist[j];
            }else{
                distance=dist[j]-dist[i-1];
            }
            if(distance==k){
                ansi=i;
                ansj=j;
                i++;
            }else if(distance>k){
                i++;
            }else{
                j++;
            }
        }
        System.out.println((ansi+1)+" "+(ansj+1));
    }
}
