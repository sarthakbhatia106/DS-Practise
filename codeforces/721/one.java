import java.io.*;
// import java.util.*;

public class one{
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            int n=Integer.parseInt(br.readLine());
            int ans=0;
            if(n<=2){
                System.out.println(n-1);
            }
            else{
                int pow=maxPowerOf2(n);
                if(n==(int)Math.pow(2,pow)){
                    System.out.println(n-1);
                }else{
                    ans=((int)Math.pow(2,pow-1))-1;
                    System.out.println(ans);
                }
            }
        }
    }
    public static int maxPowerOf2(int n){
        int mult=1;
        int pow=0;
        while(mult<n){
            mult*=2;
            pow++;
        }
        return pow;
    }
}