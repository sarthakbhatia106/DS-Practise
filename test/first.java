import java.util.*;
public class first{
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int []arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
        int k=scn.nextInt();

        rotate(arr, k);
        
        System.out.println("Array after rotation is: ");
        for(int i: arr){
            System.out.print(i+" ");
        }
    }
    public static void rotate(int []arr,int k){

        if(k>arr.length){
            k=k%arr.length;
        }

        reverse(arr,0,arr.length-k-1);
        reverse(arr,arr.length-k,arr.length-1);
        reverse(arr,0,arr.length-1);
    }
    public static void reverse(int []arr,int left,int right){

        while(left<right){
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
    }
}