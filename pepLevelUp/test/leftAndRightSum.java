package test;

import java.util.*;
public class leftAndRightSum {
    public class Node{
        int val;
        Node next;
        public Node(int val){
            this.val=val;
            this.next=null;
        }
    }
    public static void main(String[] args) {
        Scanner scn= new Scanner(System.in);
        // int n=scn.nextInt();
        // int []arr=new int[n];

        // for(int i=0;i<n;i++){
        //     arr[i]=scn.nextInt();
        // }
        String str="()()";
        // System.out.println(checkBalancedParenthesis(str));
        

        // System.out.println(equalSum(arr));
        // int ans=secondHigest(arr);
        // System.out.println(ans==Integer.MIN_VALUE?"2nd highest is not present":ans);
        scn.close();

    }
    public static int equalSum(int []arr){
        int n=arr.length;
        // int []pre=new int[n];
        // int []suff=new int[n];

        int sum=0;
        // for(int i=0;i<n;i++){
        //     sum+=arr[i];
        //     pre[i]=sum;
        // }

        for(int i=n-1;i>=0;i--){
            // sum+=arr[i];
            // suff[i]=sum;
            sum+=arr[i];
        }

        int sumPre=arr[0];
        for(int i=1;i<n-1;i++){
            if(sumPre==(sum-sumPre-arr[i])){
                return i;
            }
            sumPre+=arr[i];
        }
        return -1;
    }
    public static int secondHigest(int []arr){
        int max=Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){
            max=Math.max(max,arr[i]);
        }

        // System.out.println(max);
        int ans=Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){
            if(arr[i]>ans && arr[i]<max){
                ans=arr[i];
            }
        }
        return ans;
    }
    //select sec from students groupby(sec) having count(student_name)>50;

}
