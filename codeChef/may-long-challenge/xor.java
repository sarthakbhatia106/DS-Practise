import java.io.*;
public class xor {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            int n=Integer.parseInt(br.readLine());

            System.out.println(power(2,n-1));
        }
    }
    public static long power(int n,int m){
        if(m==0){
            return 1;
        }
        long half=power(n,m/2);
        if(m%2==0){
            return (half*half)%1000000007;
        }else{
            return (n*half*half)%1000000007;
        }
    }
}
