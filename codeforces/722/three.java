import java.io.*;
import java.util.*;

public class three {
    public static class Node {
        int l;
        int r;
        int val;
        ArrayList<Node> children;
        public Node(int l,int r,int val){
            this.l=l;
            this.r=r;
            this.val=val;
            this.children=new ArrayList<>();
        }
        public Node(){
            this.children=new ArrayList<>();
        }

      }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            int n=Integer.parseInt(br.readLine());
            ArrayList<Node> al=new ArrayList();

            for(int i=0;i<n;i++){
                String []str=br.readLine().split(" ");
                Node nn=new Node(Integer.parseInt(str[0]),Integer.parseInt(str[1]),-1);
                al.add(nn);
            }

            for(int i=0;i<n-1;i++){
                String []str=br.readLine().split(" ");
                int a=Integer.parseInt(str[0])-1;
                int b=Integer.parseInt(str[1])-1;
                Node nn1=al.get(a);
                Node nn2=al.get(b);
                nn1.children.add(nn2);
                // nn2.children.add(nn1);
            }

            System.out.println(solve(al.get(0)));

        }
    }
    public static int solve(Node node){
        if(node.children.size()==0){
            node.val=Math.max(node.l, node.r);
            return 0;
        }
        int sum=0;
        for(Node n: node.children){
            sum+=solve(n);
        }

        int sum1=0;
        int sum2=0;

        for(Node n: node.children){
            sum1+=Math.abs(node.l-n.val);
            sum2+=Math.abs(node.r-n.val);
        }

        if(sum1>sum2){
            node.val=node.l;
            return sum+sum1;
        }else{
            node.val=node.r;
            return sum+sum2;
        }
    }
}
