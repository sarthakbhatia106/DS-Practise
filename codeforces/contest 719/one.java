import java.io.*;
import java.util.Arrays;
public class one{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            int n=Integer.parseInt(br.readLine());
            String str=br.readLine();

            System.out.println(solve(str)==true?"YES":"NO");
        }
    }
    public static boolean solve(String str){
        int []count=new int[26];
        Arrays.fill(count, -1);
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(count[ch-'A']!=-1){
                if(count[ch-'A']+1==i){
                    count[ch-'A']=i;
                }else{
                    return false;
                }
            }else{
                count[ch-'A']=i;
            }
        }
        return true;
    }
}