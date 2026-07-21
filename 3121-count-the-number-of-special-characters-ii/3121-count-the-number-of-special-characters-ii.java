// class Solution {
//     public int numberOfSpecialChars(String word) {
        
//         int cnt=0;
//         for(int i=0; i<word.length(); i++){
//             char ch=word.charAt(i);

//             if(ch >= 'a' && ch<= 'z'){
//                 String sub=word.substring(i+1);
//                 String prevString=word.substring(0,i);
//                 if((sub.contains((ch+"").toUpperCase()) && !sub.contains(ch+"")) && !prevString.contains((ch+"").toUpperCase()))
//                     cnt++;
//             }
//         }

//         return cnt;
//     }
// }

class Solution {
    public int numberOfSpecialChars(String word) {

        int[] firstUpper = new int[26];
        int[] lastLower = new int[26];

        Arrays.fill(firstUpper, -1);
        Arrays.fill(lastLower, -1);

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (Character.isLowerCase(ch))
                lastLower[ch - 'a'] = i;
            else if (firstUpper[ch - 'A'] == -1)
                firstUpper[ch - 'A'] = i;
        }

        int count = 0;

        for (int i = 0; i < 26; i++) {
            if (lastLower[i] != -1 &&
                firstUpper[i] != -1 &&
                lastLower[i] < firstUpper[i]) {
                count++;
            }
        }

        return count;
    }
}