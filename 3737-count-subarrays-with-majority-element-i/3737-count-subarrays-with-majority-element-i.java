// class Solution {
//     public static boolean checkMejority(int []arr,int target){
//         int cnt=0;
//         for(int x:arr){
//             if(x==target)
//                 cnt++;
//         }

//         return cnt>arr.length/2;
//     }

//     public int countMajoritySubarrays(int[] nums, int target) {
//         int result=0;
//         for(int i=0; i<nums.length; i++){
//             for(int j=i; j<nums.length; j++){
//                 int arr[]=Arrays.copyOfRange(nums,i,j+1);
//                 // System.out.println(Arrays.toString(arr));
//                 if(checkMejority(arr,target))
//                     result++;
//             }
//         }

//         return result;
//     }
// }
class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = i; j < n; j++) {
                if (nums[j] == target) {
                    count++;
                }

                int len = j - i + 1;

                if (count > len / 2) {
                    result++;
                }
            }
        }

        return result;
    }
}