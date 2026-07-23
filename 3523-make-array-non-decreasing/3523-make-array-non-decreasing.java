class Solution {
    public int maximumPossibleSize(int[] nums) {
        int ans = 0;
        int max = 0;

        for (int num : nums) {
            if (num >= max) {
                ans++;
                max = num;
            }
        }

        return ans;
    }
}