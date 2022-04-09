package Tree;
import java.util.*;

public class inPrePost {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public class pair{
        TreeNode num;
        int ord;
        public pair(TreeNode num,int ord){
            this.num=num;
            this.ord=ord;
        }
    }
    public void postorderTraversal(TreeNode root) {
        ArrayList<Integer> in=new ArrayList<>();
        ArrayList<Integer> pre=new ArrayList<>();
        ArrayList<Integer> post=new ArrayList<>();

        Stack<pair> st=new Stack<>();
        st.push(new pair(root,1));

        while(st.size()>0){
            if(st.peek().ord==1){
                pre.add(st.peek().num.val);
                st.peek().ord++;
                if(st.peek().num.left!=null){
                    st.push(new pair(st.peek().num.left,1));
                }
            }else if(st.peek().ord==2){
                in.add(st.peek().num.val);
                st.peek().ord++;
                if(st.peek().num.right!=null){
                    st.push(new pair(st.peek().num.right,1));
                }
            }else{
                pair p=st.pop();
                post.add(p.num.val);
            }
        }

        System.out.println("Preorder");
        for(int i: pre){
            System.out.print(i+" ");
        }
        System.out.println();

        System.out.println("Inorder");
        for(int i: in){
            System.out.print(i+" ");
        }
        System.out.println();

        System.out.println("Postorder");
        for(int i: post){
            System.out.print(i+" ");
        }
    }
}
