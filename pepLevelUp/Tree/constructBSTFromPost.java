package Tree;
import java.util.*;

public class constructBSTFromPost {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int val) {
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int []arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
        Node root=constructTree(arr, n);
        inorder(root);
        scn.close();
    }

    public static Node constructTree(int post[], int n) {
        // Add your code here.
        int []nsl=new int[n];
        Stack<Integer> st=new Stack<>();
        
        for(int i=0;i<n;i++){
            if(st.size()==0){
                nsl[i]=-1;
                st.push(i);
            }else{
                while(st.size()>0 && post[st.peek()]>post[i]){
                    st.pop();
                }
                if(st.size()==0){
                    nsl[i]=-1;
                }else{
                    nsl[i]=st.peek();
                }
                st.push(i);
            }
        }
        for(int i:nsl){
            System.out.print(i+" ");
        }
        System.out.println();
        return traversal(post,nsl,0,n-1);
    }

    public static Node traversal(int[] post, int[] nsl, int ps, int pe) {
        if (ps > pe) {
            return null;
        }
        Node n = new Node(post[pe]);

        n.left = traversal(post, nsl, ps, nsl[pe]);
        n.right = traversal(post, nsl, nsl[pe] + 1, pe - 1);

        return n;
    }

    public static void inorder(Node node){
        if(node==null)return;
        inorder(node.left);
        System.out.print(node.data+" ");
        inorder(node.right);
    }
}
