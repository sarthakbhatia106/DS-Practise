package Tree;

import java.util.*;

class verticalOrder {
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

    public class pair implements Comparable<pair> {
        TreeNode n;
        int level;

        public pair(TreeNode n, int level) {
            this.n = n;
            this.level = level;
        }

        public int compareTo(pair p) {
            if (this.level == p.level) {
                return this.n.val - p.n.val;
            }

            return this.level - p.level;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        Queue<pair> q = new ArrayDeque<>();
        HashMap<Integer, List<pair>> map = new HashMap<>();
        if (root == null)
            return new ArrayList<>();

        q.add(new pair(root, 0));
        int hor = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while (q.size() > 0) {
            int size = q.size();

            while (size-- > 0) {
                pair rem = q.remove();

                if (!map.containsKey(rem.level)) {
                    map.put(rem.level, new ArrayList<>());
                }
                map.get(rem.level).add(new pair(rem.n, hor));

                min = Math.min(min, rem.level);
                max = Math.max(max, rem.level);

                if (rem.n.left != null) {
                    q.add(new pair(rem.n.left, rem.level - 1));
                }

                if (rem.n.right != null) {
                    q.add(new pair(rem.n.right, rem.level + 1));
                }
            }
            hor++;
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = min; i <= max; i++) {
            List<pair> l = map.get(i);
            Collections.sort(l);
            List<Integer> al = new ArrayList<>();
            for (pair p : l) {
                al.add(p.n.val);
            }
            ans.add(al);
        }
        return ans;
    }
}
