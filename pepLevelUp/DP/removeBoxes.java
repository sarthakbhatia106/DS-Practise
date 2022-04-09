package DP;
class Solution {
    public int removeBoxes(int[] boxes) {
        Integer[][][] dp = new Integer[boxes.length + 1][boxes.length + 1][boxes.length + 2];
        return helper(0, boxes.length - 1, 0, boxes, dp);
    }

    public int helper(int left, int right, int count, int[] boxes, Integer[][][] dp) {
        if (left < right) {
            return 0;
        }
        if (dp[left][right][count] != null) {
            return dp[left][right][count];
        }
        int l = left;
        int c = count;

        while (l <= right && boxes[l] == boxes[l + 1]) {
            l++;
            c++;
        }

        int ans = helper(l + 1, right, 0, boxes, dp) + (count + 1) * (count + 1);

        for (int i = l + 1; i <= right; i++) {
            if (boxes[i] == boxes[l]) {
                int temp = helper(l + 1, i - 1, 0, boxes, dp) + helper(i, right, c + 1, boxes, dp);
                ans = Math.max(ans, temp);
            }
        }
        dp[left][right][count] = ans;
        return ans;
    }
}