package Tree;

class recoverBSTMorris {
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

    TreeNode prev;
    TreeNode ans1;
    TreeNode ans2;

    public void recoverTree(TreeNode root) {
        prev = new TreeNode(Integer.MIN_VALUE);

        ans1 = null;
        ans2 = null;

        solve(root);

        int temp = ans1.val;
        ans1.val = ans2.val;
        ans2.val = temp;
    }

    public void solve(TreeNode root) {

        while (root != null) {
            if (root.left == null) {
                assignValues(root);
                prev = root;
                root = root.right;
            } else {
                TreeNode rootP1 = root.left;

                while (rootP1.right != null && rootP1.right != root) {
                    rootP1 = rootP1.right;
                }

                if (rootP1.right == null) {
                    rootP1.right = root;
                    root = root.left;
                } else {
                    rootP1.right = null;
                    assignValues(root);
                    prev = root;
                    root = root.right;
                }
            }
        }
    }

    public void assignValues(TreeNode root) {
        if (ans1 == null && root.val < prev.val) {
            ans1 = prev;
            ans2 = root;
        } else if (root.val < prev.val) {
            ans2 = root;
        }
    }
}
