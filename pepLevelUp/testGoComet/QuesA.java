package testGoComet;

import java.util.*;

public class QuesA {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int target = scn.nextInt();
        solve(arr, 0, 0, target, new ArrayList<>(), new HashSet<>());
    }

    private static void solve(int[] arr, int idx, int sum, int target, ArrayList<Integer> ans, HashSet<String> set) {
        if (sum == target) {
            Collections.sort(ans);
            StringBuilder sb = new StringBuilder();
            for (int i : ans) {
                sb.append(i + "#");
            }
            if (!set.contains(sb.toString())) {
                System.out.println(ans);
                set.add(sb.toString());
            }
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            if (sum + arr[i] <= target) {
                ans.add(arr[i]);
                solve(arr, i + 1, sum + arr[i], target, ans, set);
                ans.remove(ans.size() - 1);
            }
        }

    }
}
