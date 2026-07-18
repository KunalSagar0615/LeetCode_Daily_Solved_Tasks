// class Solution {
//     public int firstUniqChar(String s) {
        
//         for (int i = 0; i < s.length(); i++) {

//             int cnt = 0;

//             for (int j = 0; j < s.length(); j++) {

//                 if (i != j && s.charAt(i) == s.charAt(j)) {
//                     cnt++;
//                 }
//             }
//             if (cnt == 0)
//                 return i;
//         }
//         return -1;
//     }
// }

class Solution {
    public int firstUniqChar(String s) {

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1)
                return i;
        }

        return -1;
    }
}