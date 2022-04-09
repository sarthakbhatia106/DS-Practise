import java.io.*;
import java.util.*;
public class five {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            int n=Integer.parseInt(br.readLine());
            ArrayList<Integer> al=new ArrayList<>();
            String str=br.readLine();

            for(int i=0;i<str.length();i++){
                if(str.charAt(i)=='*'){
                    al.add(i);
                }
            }
            n=al.size();
            int median=al.size()/2;
            int itr=1;
            long ans=0;
            while(median+itr<n || median-itr>=0){
                if(median+itr<n){
                    ans+=(al.get(median+itr)-al.get(median)-itr);
                }
                if(median-itr>=0){
                    ans+=(al.get(median)-al.get(median-itr)-itr);
                }
                itr++;
            }
            System.out.println(ans);
        }
    }

}
