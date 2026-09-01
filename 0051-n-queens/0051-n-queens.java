class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];

        backtrack(0, n, board, col, diag1, diag2, result);

        return result;
    }

    private void backtrack(
        int row,
        int n,
        char[][] board,
        boolean[] col,
        boolean[] diag1,
        boolean[] diag2,
        List<List<String>> result
    ) {
        if (row == n) {
            List<String> list = new ArrayList<>();

            for (char[] r : board) {
                list.add(new String(r));
            }

            result.add(list);
            return;
        }

        for (int c = 0; c < n; c++) {
            int d1 = row - c + n - 1;
            int d2 = row + c;

            if (col[c] || diag1[d1] || diag2[d2]) {
                continue;
            }

            board[row][c] = 'Q';
            col[c] = true;
            diag1[d1] = true;
            diag2[d2] = true;

            backtrack(
                row + 1,
                n,
                board,
                col,
                diag1,
                diag2,
                result
            );

            board[row][c] = '.';
            col[c] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }
}