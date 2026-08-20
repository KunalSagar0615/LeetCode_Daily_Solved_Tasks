class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> arr1=new ArrayList<>();
        List<Integer> arr2=new ArrayList<>();

        int flag=1;
        arr1.add(nums[0]);
        int num1=nums[0];
        arr2.add(nums[1]);
        int num2=nums[1];

        for(int i=2; i<nums.length; i++){
            if(num1>num2){
                arr1.add(nums[i]);
                num1=nums[i];
            }else{
                arr2.add(nums[i]);
                num2=nums[i];
            }
        }        

        int maxLen=arr1.size();
        int result[]=new int[nums.length];
        for(int i=0; i<maxLen; i++){
            result[i]=arr1.get(i);
        }

        for(int i=0; i<arr2.size(); i++){
            result[i+maxLen]=arr2.get(i);
        }

        return result;
    }
}