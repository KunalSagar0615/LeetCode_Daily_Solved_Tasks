class Solution {
    public int numberOfSpecialChars(String word) {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch >= 'a' && ch <= 'z')
                set1.add(ch + "");
            else
                set2.add(ch + "");
        }

        int cnt = 0;
        for (String x : set1) {
            if (set2.contains(x.toUpperCase()))
                cnt++;
        }

        return cnt;
    }
}