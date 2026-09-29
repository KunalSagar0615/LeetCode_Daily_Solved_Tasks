class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Boolean[][][] dp = new Boolean[m][n][m + n];

        return dfs(grid, 0, 0, 0, dp);
    }

    private boolean dfs(char[][] grid, int r, int c, int balance,
                         Boolean[][][] dp) {

        int m = grid.length;
        int n = grid[0].length;

        if (r >= m || c >= n) return false;

        if (grid[r][c] == '(') {
            balance++;
        } else {
            balance--;
        }

        if (balance < 0) return false;

        if (r == m - 1 && c == n - 1) {
            return balance == 0;
        }

        if (dp[r][c][balance] != null) {
            return dp[r][c][balance];
        }

        boolean result =
            dfs(grid, r + 1, c, balance, dp) ||
            dfs(grid, r, c + 1, balance, dp);

        return dp[r][c][balance] = result;
    }
}