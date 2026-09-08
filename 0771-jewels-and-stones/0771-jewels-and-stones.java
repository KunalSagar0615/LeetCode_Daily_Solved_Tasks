class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Map<String, Integer> map = Arrays.stream(stones.split(""))
        .collect(Collectors.groupingBy(
                s -> s,
                Collectors.collectingAndThen(
                        Collectors.counting(),
                        Long::intValue
                )
        ));

        String[] jewelsArr = jewels.split("");
        int count=0;

        for(String jewel: jewelsArr){
            if(map.containsKey(jewel))
                count += map.get(jewel);
        }

        return count;
    }
}