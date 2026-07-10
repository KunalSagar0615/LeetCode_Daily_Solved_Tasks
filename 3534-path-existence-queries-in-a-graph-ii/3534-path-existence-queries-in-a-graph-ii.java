import java.util.*;

class Solution {

    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        int[] pos = new int[n];

        for (int i = 0; i < n; i++) {
            pos[arr[i][1]] = i;
        }

        int LOG = 17;

        while ((1 << LOG) <= n) LOG++;

        int[][] jump = new int[LOG][n];

        int r = 0;

        for (int l = 0; l < n; l++) {

            while (r + 1 < n &&
                    arr[r + 1][0] - arr[l][0] <= maxDiff) {
                r++;
            }

            jump[0][l] = r;
        }

        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                jump[k][i] = jump[k - 1][jump[k - 1][i]];
            }
        }

        int[] ans = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {

            int u = pos[queries[q][0]];
            int v = pos[queries[q][1]];

            if (u > v) {
                int temp = u;
                u = v;
                v = temp;
            }

            if (u == v) {
                ans[q] = 0;
                continue;
            }

            int cur = u;
            int dist = 0;

            for (int k = LOG - 1; k >= 0; k--) {
                if (jump[k][cur] < v) {
                    cur = jump[k][cur];
                    dist += (1 << k);
                }
            }

            if (jump[0][cur] < v) {
                ans[q] = -1;
            } else {
                ans[q] = dist + 1;
            }
        }

        return ans;
    }
}