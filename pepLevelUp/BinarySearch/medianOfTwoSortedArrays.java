package BinarySearch;

import java.util.*;

public class medianOfTwoSortedArrays {
    public void main(String[] args) {
        Scanner scn=new Scanner(System.in);

        int n=scn.nextInt();
        int m=scn.nextInt();

        int []arr1=new int[n];
        int []arr2=new int[m];

        for(int i=0;i<n;i++){
            arr1[i]=scn.nextInt();
        }
        for(int i=0;i<m;i++){
            arr2[i]=scn.nextInt();
        }
        System.out.println(findMedianSortedArrays(arr1, arr2));
        scn.close();
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        if(n>m){
            int []temp=nums1;
            nums1=nums2;
            nums2=temp;
            n=nums1.length;
            m=nums2.length;
        }

        int lo=0;
        int hi=n;
        int total=n+m;
        
        int split=(total+1)/2;
        
        while(lo<=hi){
            int mid1=lo+(hi-lo)/2;
            int mid2=split-mid1;
            
            int num1Max=getMax(nums1,mid1);
            int num2Max=getMax(nums2,mid2);
            
            int num1Min=getMin(nums1,mid1);
            int num2Min=getMin(nums2,mid2);

            if(num1Max<=num2Min && num2Max<=num1Min){
                if(total%2==0){
                    return (Math.max(num1Max,num2Max)+Math.min(num1Min,num2Min))/2.0;
                }else{
                    return 1.0*Math.max(num1Max,num2Max);
                }
            }
            
            if(num1Max>num2Min){
                hi=mid1-1;
            }else{
                lo=mid1+1;
            }
        }
        return -1;
        
    }
    public int getMax(int []nums,int idx){
        if(idx-1<0){
            return Integer.MIN_VALUE;
        }
        return nums[idx-1];
    }
    public int getMin(int []nums,int idx){
        if(idx>=nums.length){
            return Integer.MAX_VALUE;
        }
        return nums[idx];
    } 
}
