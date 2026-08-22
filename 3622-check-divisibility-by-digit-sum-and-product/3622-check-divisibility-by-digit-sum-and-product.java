class Solution {
    public boolean checkDivisibility(int n) {
        int temp=n;

        int sum=0;
        int prod=1;
        while(temp>0){
            int r=temp%10;
            
            sum=sum+r;
            prod=prod*r;

            temp/=10;
        }

        return n % (sum + prod) == 0;
    }
}