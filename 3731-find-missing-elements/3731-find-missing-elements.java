class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> lst=new ArrayList<>();

        Arrays.sort(nums);
        if(nums.length==1)
            return lst;

        int min=nums[0];
        int max=nums[nums.length-1];
        List<Integer> orignalArray=Arrays.stream(nums).boxed().toList();

        for(int i=min+1; i<max; i++){
            if(!orignalArray.contains(i))
                lst.add(i);
        }

        return lst;
    }
}