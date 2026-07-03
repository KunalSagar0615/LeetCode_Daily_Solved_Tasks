// class Solution {
//     public static boolean isPrime(int no){
//         int cnt=0;
//         for(int i=2; i<=no/2; i++){
//             if(no%i==0){
//                 cnt++;
//                 break;
//             }
//         }
//         // System.out.println("Count is"+cnt);
//         return cnt==0;
//     }
    
//     public boolean isUgly(int n) {
//         if(n<=0)
//             return false;

//         for(int i=2; i<=n; i++){
//             if(n%i==0){
//                 if(i%2!=0 && i!=2 && i!=3 && i!=5){
//                     if(isPrime(i))
//                         return false;
//                 }
//             }
//         } 

//         return true;   
//     }
// }
class Solution {
    public boolean isUgly(int n) {
        if (n <= 0) return false;

        while (n % 2 == 0) n /= 2;
        while (n % 3 == 0) n /= 3;
        while (n % 5 == 0) n /= 5;

        return n == 1;
    }
}