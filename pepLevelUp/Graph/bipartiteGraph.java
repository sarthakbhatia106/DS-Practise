package Graph;
import java.util.*;

class bipartiteGraph {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        
        int []vis=new int[n];
        Arrays.fill(vis,-1);
        
        for(int node=0;node<n;node++){
            if(vis[node]!=-1)continue;
            vis[node]=1;
            Queue<Integer> q=new ArrayDeque<>();
            q.add(node);

            while(q.size()>0){
                int rem=q.remove();
                for(int i=0;i<graph[rem].length;i++){
                    if(vis[graph[rem][i]]==-1){
                        if(vis[rem]==1){
                            vis[graph[rem][i]]=2;                        
                        }else{
                            vis[graph[rem][i]]=1;
                        }
                        q.add(graph[rem][i]);
                    }else{
                        if(vis[graph[rem][i]]==vis[rem]){
                            return false;
                        }
                    }
                }
            }   
        }
        return true;
    }
}