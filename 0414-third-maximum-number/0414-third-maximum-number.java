// class Solution {
//     public int thirdMax(int[] nums) {
//         Arrays.sort(nums);
//         int first=nums[0];
//         int second=nums[0];
//         int third=nums[0];
//         for(int x: nums){
//             if(x>first){
//                 third=second;
//                 second=first;
//                 first=x;
//             }
//         }

//         return third;
//     }
// }
class Solution {
    public int thirdMax(int[] nums) {

        Arrays.sort(nums);

        int count = 1;
        int max = nums[nums.length - 1];

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] != nums[i + 1]) {
                count++;
                if (count == 3)
                    return nums[i];
            }
        }

        return max;
    }
}