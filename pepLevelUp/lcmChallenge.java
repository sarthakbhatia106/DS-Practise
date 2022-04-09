import java.util.*;
public class lcmChallenge {
    public static void main(String[] args) throws java.lang.Exception{
        Scanner scn = new Scanner(System.in);
        long m=scn.nextLong();
        long ans=1;
        
        if(m==1 || m==2){
            System.out.println(m);
            scn.close();
            return;
        }

        
        if(m%2==0){
            long gcd=gcd(m,m-3);
            if(gcd==1){
                ans=(m*(m-1)*(m-3));
            }else{
                ans=((m-3)*(m-1)*(m-2));
            }
        }else{
            ans=(m*(m-1)*(m-2));
        }
        System.out.println(ans);
        scn.close();
    }
    public static long gcd(long n,long m){
        if(m==0){
            return n;
        }
        return gcd(m,n%m);
    }
}
