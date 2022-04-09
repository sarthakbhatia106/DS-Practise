package Graph;

import java.util.*;

class Solution1 {
    public int secondMinimum(int n, int[][] edges, int time, int change) {

        ArrayList<HashSet<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            graph.add(new HashSet<>());
        }

        for (int[] i : edges) {
            graph.get(i[0]).add(i[1]);
            graph.get(i[1]).add(i[0]);
        }

        int []vis=new int[n+1];

        Queue<Integer> q=new ArrayDeque<>();

        boolean lastfind=false;
        boolean findmin=false;

        int ans=0;
        q.add(1);

        while(q.size()>0){
            ans+=time;
            int size=q.size();
            while(size-->0){
                int rem=q.remove();
                vis[rem]++;

                for(int nbr:graph.get(rem)){
                    if(vis[nbr]>=2)continue;

                    if(lastfind && findmin && nbr==n){
                        return ans;
                    }
                    q.add(nbr);
                    if(nbr==n)findmin=true;
                }
            }
            if(findmin)lastfind=true;
            if((ans/change)%2==1){
                ans+=change-(ans%change);
            }
        }
        return -1;
    }
}