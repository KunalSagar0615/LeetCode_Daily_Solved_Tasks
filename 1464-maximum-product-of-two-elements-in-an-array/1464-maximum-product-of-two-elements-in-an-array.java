class Solution {
    public int maxProduct(int[] nums) {
        int product=1;
        if(nums.length<=2){
            for(int i=0; i<nums.length; i++){
                product=product*(nums[i]-1);
            }

            return product;

        }else{
            Arrays.sort(nums);
            int max=nums[nums.length-1];
            int secMax=nums[nums.length-2];

            product=(max-1)*(secMax-1);
        }

        return product;
    }
}