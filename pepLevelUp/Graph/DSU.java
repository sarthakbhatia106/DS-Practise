package Graph;
import java.util.*;

public class DSU {
    int []par;
    int []rank;
    public void union(int x,int y){

        int lx=find(x);
        int ly=find(y);

        if(lx!=ly){
            if(rank[lx]>rank[ly]){
                par[ly]=lx;
            }else if(rank[ly]>rank[ly]){
                par[lx]=ly;
            }else{
                par[lx]=ly;
                rank[ly]++;
            }
        }
    } 
    public int find(int x){
        if(x==par[x]){
            return x;
        }

        int temp=find(par[x]);
        par[x]=temp;
        return temp;
    }
}
