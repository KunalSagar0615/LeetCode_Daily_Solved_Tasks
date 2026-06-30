// class Solution {

//     public int numberOfSubstrings(String s) {
//         int cnt=0;

//         for(int i=0; i<s.length(); i++){
//             for(int j=i; j<s.length(); j++){
//                 String str=s.substring(i,j+1);
//                 if(str.contains("a") && str.contains("b") && str.contains("c"))
//                     cnt++;
//             }
//         }

//         return cnt;
//     }
// }

class Solution {
    public int numberOfSubstrings(String s) {

        int lastA = -1;
        int lastB = -1;
        int lastC = -1;

        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == 'a') lastA = i;
            else if (ch == 'b') lastB = i;
            else lastC = i;

            int minIndex = Math.min(lastA, Math.min(lastB, lastC));

            if (minIndex != -1)
                count += minIndex + 1;
        }

        return count;
    }
}