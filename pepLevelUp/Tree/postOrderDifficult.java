package Tree;
import java.util.*;

public class postOrderDifficult {
    /**
     * Definition for a binary tree node. public class TreeNode { int val; TreeNode
     * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
     * = left; this.right = right; } }
     */
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

    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {

            List<Integer> al = new ArrayList<>();
            if (root == null)
                return al;
            Stack<TreeNode> st = new Stack<>();
            TreeNode node = root;

            while (st.size() > 0 || node != null) {
                if (node != null) {
                    st.push(node);
                    node = node.left;
                } else {
                    TreeNode temp = st.peek().right;

                    if (temp == null) {
                        temp = st.pop();
                        al.add(temp.val);
                        while (st.size() > 0 && st.peek().right == temp) {
                            temp = st.pop();
                            al.add(temp.val);
                        }
                    } else {
                        node = temp;
                    }
                }
            }

            return al;
        }
    }
}
