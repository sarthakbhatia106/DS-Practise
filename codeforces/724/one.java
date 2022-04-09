import java.io.*;
import java.util.*;

public class one {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            int n=Integer.parseInt(br.readLine());
            int []arr=new int[n];
            String []str=br.readLine().split(" ");
            HashSet<Integer> set=new HashSet<>();
            ArrayList<Integer> al=new ArrayList<>();

            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(str[i]);
                al.add(arr[i]);
                set.add(arr[i]);
            }
            
            if(set.size()!=n){
                System.out.println("NO");
            }else{
                boolean check=true;
                for(int i=0;i<al.size();i++){
                    for(int j=i-1;j>=0;j--){
                        int diff=Math.abs(al.get(i)-al.get(j));
                        if(set.contains(diff))continue;
                        else{
                            al.add(diff);
                            set.add(diff);
                        }
                        if(al.size()>300){
                            check=false;
                            break;
                        }
                    }
                    if(check==false){
                        break;
                    }
                }
                if(check==false){
                    System.out.println("NO");
                }else{
                    System.out.println("YES");
                    System.out.println(set.size());
                    for(int i:set){
                        System.out.print(i+" ");
                    }
                    System.out.println();
                }
            }

        }
    }    
}
