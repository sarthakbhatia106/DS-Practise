package Tree;
import java.util.*;
public class buddyNim {
    public static void main(String[] args) throws java.lang.Exception{
        Scanner scn = new Scanner(System.in);
        int t=scn.nextInt();
        while(t-->0){
            int n=scn.nextInt();
            int m=scn.nextInt();
            int []a=new int[n];
            int []b=new int[m];
            int c1=0;
            int c2=0;
            for(int i=0;i<n;i++){
                a[i]=scn.nextInt();
                c1+=a[i];
            }

            for(int i=0;i<m;i++){
                b[i]=scn.nextInt();
                c2+=b[i];
            }

            if(c1!=c2){
                System.out.println("Alice");
            }else{
                
                boolean same=true;
                int i=0;
                int j=0;
                Arrays.sort(a);
                Arrays.sort(b);

                while(a[i]==0){
                    i++;
                }
                while(b[j]==0){
                    j++;
                }

                while(i<n && j<m){
                    if(a[i]!=b[j]){
                        same=false;
                        break;
                    }
                    i++;
                    j++;
                }
                if(same && i==n && j==m){
                    System.out.println("Bob");
                }else{
                    System.out.println("Alice");
                }
            }
        }
        scn.close();
    }
}
