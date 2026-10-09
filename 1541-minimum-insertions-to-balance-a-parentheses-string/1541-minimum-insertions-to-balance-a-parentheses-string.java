
class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int open = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                open++;
            } else {
                // Handle the first closing parenthesis
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++;
                } else {
                    // Insert one ')' to complete the pair
                    insertions++;
                }

                // Match the closing pair with an opening '('
                if (open > 0) {
                    open--;
                } else {
                    // Insert one '(' because no opening exists
                    insertions++;
                }
            }
        }

        // Each unmatched '(' needs two ')'
        return insertions + open * 2;
    }
}
