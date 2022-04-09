package testGoComet;

import java.util.*;

public class QuesB {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n1=scn.nextInt();
        HashSet<Integer> set1=new HashSet<>();
        for(int i=0;i<n1;i++){
            set1.add(scn.nextInt());
        }

        HashSet<Integer> set2=new HashSet<>();
        int n2=scn.nextInt();
        for(int i=0;i<n2;i++){
            set2.add(scn.nextInt());
        }

        System.out.print("Output: ");
        for(int i:set1){
            if(set2.contains(i)){
                System.out.print(i+" ");
            }
        }
    }    

}
