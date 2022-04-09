import java.util.*;
public class palindromeEasy {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int t=scn.nextInt();
        while(t-->0){
            int n=scn.nextInt();
            String str=scn.next();

            int count=0;
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)=='0'){
                    count++;
                }
            }

            if(count%2==0){
                System.out.println("BOB");
            }else{
                if(count==1){
                    System.out.println("BOB");
                }else{
                    System.out.println("ALICE");
                }
            }
        }
        scn.close();
    }
}
