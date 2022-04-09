package Tree;

class Solution {
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

    int ans;

    public int minCameraCover(TreeNode root) {
        ans = 0;

        if (root == null)
            return ans;
        int x = solve(root);
        if (x == 0)
            ans++;

        return ans;
    }

    public int solve(TreeNode root) {
        if (root == null) {
            return 2;
        }

        int left = solve(root.left);
        int right = solve(root.right);

        if (left == 0 || right == 0) {
            ans++;
            return 1;
        }

        if (left == 2 && right == 2)
            return 0;
        return 2;
    }
}