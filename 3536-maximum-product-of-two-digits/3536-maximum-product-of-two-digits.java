class Solution {
    public int maxProduct(int n) {
        int size=String.valueOf(n).length();

        if(size<=1)
            return n;

        int arr[]=new int[size];

        int i=0;
        while(n>0){
            arr[i++]=n%10;
            n/=10;
        }

        Arrays.sort(arr);

        int max=arr[arr.length-1];
        int secondMax=arr[arr.length-2];

        return max*secondMax;
    }
}