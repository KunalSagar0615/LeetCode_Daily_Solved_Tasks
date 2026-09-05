// class Solution {
//     public int firstStableIndex(int[] nums, int k) {

//         for (int i = 0; i < nums.length; i++) {

//             int max = nums[0];
//             int min = nums[i];

//             for (int j = 0; j <= i; j++) {
//                 if (max < nums[j])
//                     max = nums[j];
//             }

//             for (int j = i; j < nums.length; j++) {
//                 if (min > nums[j])
//                     min = nums[j];
//             }

//             if (max - min <= k)
//                 return i;
//         }

//         return -1;
//     }
// }
class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        int[] suffixMin = new int[n];
        suffixMin[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], nums[i]);
        }

        int prefixMax = 0;

        for (int i = 0; i < n; i++) {
            prefixMax = Math.max(prefixMax, nums[i]);

            if (prefixMax - suffixMin[i] <= k) {
                return i;
            }
        }

        return -1;
    }
}