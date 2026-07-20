// class Solution {
//     public char findTheDifference(String s, String t) {
//         Set<String> set=new HashSet<>();
//         for(char x: s.toCharArray()){
//             set.add(x+"");
//         }

//         char ch=0;
//         for(char x:t.toCharArray()){
//             if(!set.contains(x+"")){
//                 ch=x;
//                 break;
//             }
//         }

//         return ch;
//     }
// }

class Solution {
    public char findTheDifference(String s, String t) {

        char result = 0;

        for (char ch : s.toCharArray()) {
            result ^= ch;
        }

        for (char ch : t.toCharArray()) {
            result ^= ch;
        }

        return result;
    }
}