import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            map.put(row, map.getOrDefault(row, 0) | (1 << (col - 1)));
        }

        int ans = (n - map.size()) * 2;

        int left = 30;    // seats 2,3,4,5
        int middle = 120; // seats 4,5,6,7
        int right = 480;  // seats 6,7,8,9

        for (int seats : map.values()) {

            boolean canLeft = (seats & left) == 0;
            boolean canRight = (seats & right) == 0;
            boolean canMiddle = (seats & middle) == 0;

            if (canLeft && canRight) {
                ans += 2;
            } else if (canLeft || canRight || canMiddle) {
                ans++;
            }
        }

        return ans;
    }
}