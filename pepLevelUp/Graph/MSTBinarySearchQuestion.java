package Graph;
import java.util.*;

class Solution {
    public boolean solve(int[][] edges, int a, int b) {

        HashSet<Integer> set=new HashSet<>();
        for(int []arr: edges){
            set.add(arr[0]);
            set.add(arr[1]);
        }
        
        int ans1=kruskals(edges,a,b,set.size(),true);
        int ans2=kruskals(edges,a,b,set.size(),false);

        return ans1==ans2;
    }
    public int kruskals(int [][]edges,int a,int b,int n,boolean check){
        int cost=0;
        int []par=new int[n];
        int []rank=new int[n];
        for(int i=0;i<n;i++){
            par[i]=i;
            rank[i]=0;
        }
        if(check==true){
            for(int []arr:edges){
                if((arr[0]==a && arr[1]==b) || (arr[0]==b && arr[1]==a)){
                    cost+=arr[2];
                    union(a,b,par,rank);
                }
            }
        }


        Arrays.sort(edges,(x,y)->(x[2]-y[2]));
        for(int []arr: edges){
            if(check && (arr[0]==a && arr[1]==b) || (arr[0]==b && arr[1]==a)){
                continue;
            }

            boolean flag=union(arr[0],arr[1],par,rank);
            if(flag==true){
                cost+=arr[2];
            }
        }
        return cost;
    }
    public boolean union(int x,int y, int []par,int []rank){
        int px=find(x,par,rank);
        int py=find(y,par,rank);

        if(px==py){
            return false;
        }else{
            if(rank[px]<rank[py]){
                par[px]=py;
            }else if(rank[py]<rank[px]){
                par[py]=px;
            }else{
                par[py]=px;
                rank[px]++;
            }
            return true;
        }
    }
    public int find(int x,int[]par, int []rank){
        if(par[x]==x){
            return x;
        }
        return par[x]=find(par[x],par,rank);
    }
}