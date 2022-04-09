import java.util.*;
public class third {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int []arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
        int k=scn.nextInt();

        System.out.println(kthSmallest(arr,k));
    }   
    public static int kthSmallest(int []arr, int k){

        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<arr.length;i++){
            if(pq.size()<k){
                pq.add(arr[i]);
            }else{
                if(arr[i]<pq.peek()){
                    pq.remove();
                    pq.add(arr[i]);
                }
            }
        }
        return pq.remove();
    }
}
