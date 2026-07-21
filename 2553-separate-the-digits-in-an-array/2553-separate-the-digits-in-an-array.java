// class Solution {
//     public int[] separateDigits(int[] nums) {
//         List<Integer> lst=new ArrayList<>();

//         for(int i=0; i<nums.length; i++){
//             if(String.valueOf(nums[i]).length()==1)
//                 lst.add(nums[i]);
//             else{
//                 int no=nums[i];
//                 do{
                    
//                     lst.add(no%10);
//                     no/=10;
//                 }while(no!=0);
//             }
//         }

//         return lst.stream().mapToInt(Integer::intValue).toArray();
//     }
// }

class Solution {
    public int[] separateDigits(int[] nums) {

        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            String s = String.valueOf(num);

            for (char ch : s.toCharArray()) {
                list.add(ch - '0');
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}