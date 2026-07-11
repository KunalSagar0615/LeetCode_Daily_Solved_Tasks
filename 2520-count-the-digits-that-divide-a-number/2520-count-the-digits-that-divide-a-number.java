class Solution {
    public int countDigits(int num) {
        int n=num;
        int cnt=0;
        
        while(n>0){
            int r=n%10;

            if(num%r==0)
                cnt++;
        
            n/=10;
        }

        return cnt;
    }
}