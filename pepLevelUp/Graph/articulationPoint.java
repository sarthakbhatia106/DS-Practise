package Graph;
import java.util.*;

public class articulationPoint {
    static int []disc;
    static int []low;
    static int []par;
    static boolean []vis;
    static boolean []ap;
    static int time;
    static int count;

    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);

        while(true){
            int n=scn.nextInt();
            int m=scn.nextInt();
            if(n==0 && m==0){
                scn.close();
                return;
            }
            int [][]arr=new int[m][2];
            for(int i=0;i<m;i++){
                arr[i][0]=scn.nextInt();
                arr[i][1]=scn.nextInt();
            }
            System.out.println(doctorStrange(n, m, arr));
        }
    }
    
    public static int doctorStrange (int n, int k, int g[][]) {
        
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0;i<g.length;i++){
            int u=g[i][0];
            int v=g[i][1];
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        disc=new int[n+1];
        low=new int[n+1];
        par=new int[n+1];
        vis=new boolean [n+1];
        ap=new boolean [n+1];
        time=0;
        count=0;
        
        articulationP(1,graph);
        int ans=0;
        for(int i=0;i<ap.length;i++){
            if(ap[i]==true)ans++;
        }
        return ans;
    }
    public static void articulationP(int u,ArrayList<ArrayList<Integer>> graph){
        low[u]=disc[u]=time;
        time++;

        vis[u]=true;

        for(int v: graph.get(u)){
            if(par[u]==v){
                continue;
            }else if(vis[v]==true){
                low[u]=Math.min(low[u],disc[v]);
            }else{
                par[v]=u;
                articulationP(v, graph);

                if(par[u]==0){
                    count++;
                    if(count>=2){
                        ap[u]=true;
                    }
                }else{
                    if(low[v]>=disc[u]){
                        ap[u]=true;
                    }
                }
                low[u]=Math.min(low[u],low[v]);
            }
        }
    }
}
