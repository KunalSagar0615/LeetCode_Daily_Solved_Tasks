class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> lst = new ArrayList<>();

        String c = x + "";

        int i=0;
        for(String word: words){
            if(word.contains(c))
                lst.add(i);

            i++;
        } 

        return lst;
    }
}