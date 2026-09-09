class Solution {
    public int missingNumber(int[] nums) {
        int no=0;
        int found=0;
        while(no < nums.length){
            
            found=0;
            
            for(int i=0; i<nums.length; i++){
                
                if(no==nums[i]){
                    found=1;
                    break;
                }

            }

            if(found==0)
                return no;

        no++;
        }

        return no;
    }
}