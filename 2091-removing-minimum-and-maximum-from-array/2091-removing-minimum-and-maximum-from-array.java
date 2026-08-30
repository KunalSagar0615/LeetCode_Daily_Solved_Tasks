class Solution {
    public int minimumDeletions(int[] nums) {

        int n = nums.length;

        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }

            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        int first = Math.min(minIndex, maxIndex);
        int second = Math.max(minIndex, maxIndex);

        int option1 = second + 1;           
        int option2 = n - first;             
        int option3 = first + 1 + n - second; 

        return Math.min(option1, Math.min(option2, option3));
    }
}