class Solution {
    public int maximumLengthSubstring(String s) {
        int j = 0;
        int maxLen = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.get(ch) > 2) {
                char left = s.charAt(j);
                map.put(left, map.get(left) - 1);
                j++;
            }

            maxLen = Math.max(maxLen, i - j + 1);
        }

        return maxLen;
    }
}