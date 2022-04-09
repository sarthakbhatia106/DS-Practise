import java.util.*;
public class palindromeHard {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int t=scn.nextInt();
        while(t-->0){
            int n=scn.nextInt();
            String str=scn.next();
            boolean isPalindrome=true;

            int count=0;
            int count1=0;
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)=='0'){
                    count++;
                }
            }

            for(int i=0;i<str.length()/2;i++){
                if(str.charAt(i)!=str.charAt(n-i-1))isPalindrome=false;

                if((str.charAt(i)=='1' || str.charAt(n-i-1)=='1') && str.charAt(i)!=str.charAt(n-i-1)){
                    count1++;
                }
            }

            if(isPalindrome){
                if(count%2==0){
                    System.out.println("BOB");
                }else{
                    if(count==1){
                        System.out.println("BOB");
                    }else{
                        System.out.println("ALICE");
                    }
                }
            }else{
                if(count1==1 && count==2){
                    System.out.println("DRAW");
                }else{
                    System.out.println("ALICE");
                }
            }
        }
        scn.close();
    }
}
