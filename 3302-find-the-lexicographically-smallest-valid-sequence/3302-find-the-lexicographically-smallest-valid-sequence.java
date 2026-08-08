class Solution {
    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int[] ans = new int[m];

        // last[j] = latest index in word1 from which
        // word2[j] can be matched.
        int[] last = new int[m];

        for (int i = 0; i < m; i++) {
            last[i] = -1;
        }

        // Find the latest possible positions for word2
        // by matching from right to left.
        int i = n - 1;
        int j = m - 1;

        while (i >= 0 && j >= 0) {
            if (word1.charAt(i) == word2.charAt(j)) {
                last[j] = i;
                j--;
            }
            i--;
        }

        // We are allowed to use one mismatch.
        boolean usedMismatch = false;

        i = 0;
        j = 0;

        while (i < n && j < m) {

            // Exact match: always prefer it.
            if (word1.charAt(i) == word2.charAt(j)) {
                ans[j] = i;
                j++;
            }

            // Try using the one allowed mismatch.
            else if (!usedMismatch &&
                     (j == m - 1 || i < last[j + 1])) {

                ans[j] = i;
                j++;
                usedMismatch = true;
            }

            i++;
        }

        // Couldn't match all characters.
        if (j < m) {
            return new int[0];
        }

        return ans;
    }
}