class Solution {

    int[] leftLen, rightLen, maxLen, length;
    char[] leftChar, rightChar;

    public int[] longestRepeating(
        String s,
        String queryCharacters,
        int[] queryIndices
    ) {
        int n = s.length();
        int size = 4 * n;

        leftLen = new int[size];
        rightLen = new int[size];
        maxLen = new int[size];
        length = new int[size];

        leftChar = new char[size];
        rightChar = new char[size];

        build(1, 0, n - 1, s);

        int[] ans = new int[queryIndices.length];

        for (int i = 0; i < queryIndices.length; i++) {

            update(
                1,
                0,
                n - 1,
                queryIndices[i],
                queryCharacters.charAt(i)
            );

            ans[i] = maxLen[1];
        }

        return ans;
    }

    private void build(int node, int l, int r, String s) {

        length[node] = r - l + 1;

        if (l == r) {
            leftChar[node] = rightChar[node] = s.charAt(l);
            leftLen[node] = rightLen[node] = maxLen[node] = 1;
            return;
        }

        int mid = (l + r) / 2;

        build(node * 2, l, mid, s);
        build(node * 2 + 1, mid + 1, r, s);

        pull(node);
    }

    private void update(
        int node,
        int l,
        int r,
        int index,
        char c
    ) {

        if (l == r) {
            leftChar[node] = rightChar[node] = c;
            leftLen[node] = rightLen[node] = maxLen[node] = 1;
            return;
        }

        int mid = (l + r) / 2;

        if (index <= mid) {
            update(node * 2, l, mid, index, c);
        } else {
            update(node * 2 + 1, mid + 1, r, index, c);
        }

        pull(node);
    }

    private void pull(int node) {

        int left = node * 2;
        int right = node * 2 + 1;

        leftChar[node] = leftChar[left];
        rightChar[node] = rightChar[right];

        leftLen[node] = leftLen[left];
        rightLen[node] = rightLen[right];

        maxLen[node] = Math.max(maxLen[left], maxLen[right]);

        if (rightChar[left] == leftChar[right]) {

            maxLen[node] = Math.max(
                maxLen[node],
                rightLen[left] + leftLen[right]
            );

            if (leftLen[left] == length[left]) {
                leftLen[node] =
                    leftLen[left] + leftLen[right];
            }

            if (rightLen[right] == length[right]) {
                rightLen[node] =
                    rightLen[left] + rightLen[right];
            }
        }
    }
}