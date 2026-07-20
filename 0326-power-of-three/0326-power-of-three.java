// class Solution {
//     public boolean isPowerOfThree(int n) {

//         if(n==1)
//             return true;

//         int result = 3;
//         boolean flag = false;
//         while (result <= n) {
//             if (result == n) {
//                 flag = true;
//                 break;
//             }

//             result=result*3;
//         }

//         return flag;
//     }
// }
class Solution {
    public boolean isPowerOfThree(int n) {

        if (n <= 0)
            return false;

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }
}