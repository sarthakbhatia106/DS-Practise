package Tree;

public class coloringGameLeetcode {
    class TreeNode {
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

    int lc, rc;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        lc = 0;
        rc = 0;

        traversal(root, x);

        int max = Math.max(lc, Math.max(rc, n - lc - rc - 1));
        return max > n / 2;
    }

    public int traversal(TreeNode root, int x) {
        if (root == null)
            return 0;

        int left = traversal(root.left, x);
        int right = traversal(root.right, x);

        if (root.val == x) {
            lc = left;
            rc = right;
        }
        return left + right + 1;
    }
}