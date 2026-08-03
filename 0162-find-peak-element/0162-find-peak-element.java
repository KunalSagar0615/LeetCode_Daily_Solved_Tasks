// class Solution {
//     public int findPeakElement(int[] nums) {
//      if(nums.length<=4){
//      int max=nums[0];
//      int index=0;
//         for(int i=0; i<nums.length; i++){
//         if(max<nums[i])
//             index=i;            
//         }
//         return index;
//      }

//      for(int i=1; i<nums.length-1; i++){
//         if(nums[i]>nums[i+1] && nums[i]>nums[i-1])
//             return i;
//      }   

//      return 0;
//     }
// }
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}