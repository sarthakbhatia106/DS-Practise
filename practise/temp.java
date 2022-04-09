import java.util.*;
public class temp {
    public static void main(String[] args) {
        
        int []arr={4,4,4,1,3,7,7,2,2,2,7,8,2,3,3,3,1};

        System.out.println(findDuplicates(arr));
    }
    public static List<Integer> findDuplicates(int[] nums) {
        
        List<Integer> al=new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            int val=nums[i];
            
            if(val<0)val*=-1;
            
            if(nums[val-1]<0)al.add(val);
            else nums[val-1]*=-1;
        }
        return al;
    }
}
