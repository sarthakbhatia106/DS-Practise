package testGoComet;

import java.util.*;

public class QuesC {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        
        int a=scn.nextInt();
        int b=scn.nextInt();
        int c=scn.nextInt();
        int n=scn.nextInt();

        System.out.println(nthGeekonacci(a,b,c,n));
    }

    private static int nthGeekonacci(int a, int b, int c, int n) {
        if(n==1){
            return a;
        }else if(n==2){
            return b;
        }else if(n==3){
            return c;
        }
        return nthGeekonacci(a, b, c, n-1)+nthGeekonacci(a, b, c, n-2)+nthGeekonacci(a, b, c, n-3);
    }    
    
}
