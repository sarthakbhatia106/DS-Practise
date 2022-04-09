package Graph;
//--------------------------Question----------------------------
// There are N homes in a village, we have to facilitate water supply in each of them. 
//We can either build a well in a home or connect it with pipe to some different home already having water supply.
//More formally, we can either build a new well in the home or connect it with a pipeline to some different home 
//which either has it’s own well or further gets water supply from a different home and so on. 
//There is some cost associated with both building a new well and laying down a new pipeline. 
//We have to supply water in all homes and minimise the total cost.

// Input-
// First line contains an integer N, the number of homes.
// The next line contains N integers, the ith integer denotes the cost of building a well in that home.
// Next line contains an integer K, then K lines follows. Each of which contains 3 integers i, j and p. Which denotes the cost ‘p’ of laying down pipeline between homes i and j.

// Output-
// Output a single integer - the minimum cost to supply water to all the homes


import java.util.*;
public class optimizeWaterDistributedInVillage {
    public class Pair implements Comparable<Pair>{
        int u;
        int v;
        int wt;
        public Pair(int u,int v,int wt){
            this.u=u;
            this.v=v;
            this.wt=wt;
        }
        @Override
        public int compareTo(Pair o) {
            return this.wt-o.wt;
        }
    }
    
    int []par;
    int []rank;
    public int minCost(int n,int []wells, int [][]pipes){

        Pair []edges=new Pair[pipes.length+n];

        int idx=0;
        for(int []pipe: pipes){
            int u=pipe[0];
            int v=pipe[1];
            int wt=pipe[2];
            edges[idx++]=new Pair(u, v, wt);
        }

        for(int i=0;i<wells.length;i++){
            int u=0;
            int v=i+1;
            int wt=wells[i];
            edges[idx++]=new Pair(u, v, wt);
        }

        int ans=0;
        Arrays.sort(edges);
        par=new int[n+1];
        rank=new int[n+1];

        for(int i=0;i<=n;i++){
            par[i]=i;
            rank[i]=1;
        }

        for(int i=0;i<edges.length;i++){
            int u=edges[i].u;
            int v=edges[i].v;
            int wt=edges[i].wt;

            boolean flag=union(u,v);
            if(!flag){
                ans+=wt;
            }
        }
        return ans;
    }

    public int find(int x){
        if(par[x]==x){
            return x;
        }
        
        int temp=find(par[x]);
        par[x]=temp;
        return temp;
    }
    public boolean union(int x,int y){
        int lx=find(x);
        int ly=find(y);
        
        if(lx==ly){
            return true;
        }
        
        if(rank[lx]>rank[ly]){
            par[ly]=lx;
        }else if(rank[lx]<rank[ly]){
            par[lx]=ly;
        }else{
            par[lx]=ly;
            rank[ly]++;
        }
        return false;
    }
}

//revision code
class test1 {
    int[] par;
    int[] rank;

    public int minCost(int n, int[] wells, int[][] pipes) {
        
        int[][] edges = new int[n + pipes.length][3];
        par = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            par[i] = i;
            rank[i] = 1;
        }
        int idx = 0;
        for (int i = 0; i < pipes.length; i++) {
            edges[idx++] = pipes[i];
        }
        for (int i = 1; i <= n; i++) {
            edges[idx][0] = 0;
            edges[idx][1] = i;
            edges[idx][2] = wells[i - 1];
            idx++;
        }

        Arrays.sort(edges, (a, b) -> a[2] - b[2]);
        int ans = 0;
        for (int i = 0; i < edges.length; i++) {
            boolean check = union(edges[i][0], edges[i][1]);
            if (check == true) {
                ans += edges[i][2];
            }
        }

        return ans;
    }

    public boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) {
            return false;
        } else {
            if (rank[px] < rank[py]) {
                par[px] = py;
            } else if (rank[py] < rank[px]) {
                par[py] = px;
            } else {
                par[py] = px;
                rank[px]++;
            }
            return true;
        }
    }

    private int find(int x) {
        if (x == par[x]) {
            return x;
        }
        return par[x] = find(par[x]);
    }
}
