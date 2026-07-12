class Solution {
    public int[] arrayRankTransform(int[] arr) {

        int[] sorted=arr.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> map=new HashMap<>();

        int rank=1;
        for(int x: sorted){
            if(!map.containsKey(x)){
                map.put(x,rank++);
            }
        }

        for(int i=0; i<arr.length; i++){
            arr[i]=map.get(arr[i]);//it returns index/rank (key)
        }

        return arr;
    }
}