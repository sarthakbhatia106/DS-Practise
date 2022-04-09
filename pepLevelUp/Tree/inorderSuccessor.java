package Tree;

public class inorderSuccessor {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode solve(TreeNode root, TreeNode p) {
        // write your code here
        TreeNode ans = null;
        if (root == null)
            return root;

        while (root != null) {
            if (p.val > root.val && root.right != null) {
                root = root.right;
            } else if (p.val == root.val) {
                TreeNode temp = root.right;
                if (temp == null) {
                    return ans;
                }
                while (temp.left != null) {
                    temp = temp.left;
                }
                return temp;
            } else {
                ans = root;
                root = root.left;
            }
        }
        return ans;
    }
}
