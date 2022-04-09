// import java.util.*;
import java.io.*;
public class one {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            String []str=br.readLine().split(" ");
            int D=Integer.parseInt(str[0]);
            int d=Integer.parseInt(str[1]);
            int a=Integer.parseInt(str[2]);
            int b=Integer.parseInt(str[3]);
            int c=Integer.parseInt(str[4]);

            int n=D*d;
            if(n>=10 && n<21){
                System.out.println(a);
            }else if(n>=21 && n<42){
                System.out.println(b);
            }else if(n>=42){
                System.out.println(c);
            }else{
                System.out.println(0);
            }
            
        }
    }
}
