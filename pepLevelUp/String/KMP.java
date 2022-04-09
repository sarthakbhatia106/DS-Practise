package String;
import java.util.*;

public class KMP {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        
        String str=scn.next();
        String pat=scn.next();

        String s=pat+"#"+str;
        int []lps=new int[s.length()+1];

        findLps(s,lps);
        int ans=0;
        for(int i: lps){
            if(i==pat.length())ans++;
        }
        System.out.println(ans);
        scn.close();
    }

    private static void findLps(String s, int[] lps) {
        int i=1;
        int len=0;

        while(i<s.length()){
            if(s.charAt(i)==s.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }else{
                if(len>0){
                    len=lps[len-1];  
                }else{
                    i++;
                }
            }
        }
    }
}
