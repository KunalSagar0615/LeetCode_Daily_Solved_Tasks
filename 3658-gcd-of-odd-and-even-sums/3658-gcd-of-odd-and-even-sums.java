class Solution {
    public int gcdOfOddEvenSums(int n) {

        int evenSum=0;
        int oddSum=0;
        int digit=1;
        for(int i=0; i<n; i++){
            oddSum+=digit++;
            evenSum+=digit++;
        }

        int result=1;
        for(int i=1; i<=oddSum/2; i++){
            if(oddSum%i==0 && evenSum%i==0)
                result=i;
        }

        return result;
    }
}