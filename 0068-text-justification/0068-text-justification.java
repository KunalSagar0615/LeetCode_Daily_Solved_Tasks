class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int j = i;
            int len = 0;

            while (j < words.length &&
                   len + words[j].length() + (j - i) <= maxWidth) {
                len += words[j].length();
                j++;
            }

            int spaces = maxWidth - len;
            int gaps = j - i - 1;

            StringBuilder line = new StringBuilder();

            // Last line or line with only one word
            if (j == words.length || gaps == 0) {
                for (int k = i; k < j; k++) {
                    if (k > i) {
                        line.append(" ");
                    }
                    line.append(words[k]);
                }

                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } else {
                int evenSpaces = spaces / gaps;
                int extraSpaces = spaces % gaps;

                for (int k = i; k < j; k++) {
                    line.append(words[k]);

                    if (k < j - 1) {
                        int count = evenSpaces;

                        if (k - i < extraSpaces) {
                            count++;
                        }

                        line.append(" ".repeat(count));
                    }
                }
            }

            result.add(line.toString());
            i = j;
        }

        return result;
    }
}