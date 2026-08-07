import java.util.*;

class Solution {
    private static final int[] PRIMES = {2, 3, 5, 7};

    // factor contribution of each digit, indexed [digit][primeIndex] for primes {2,3,5,7}
    private static final int[][] DF = {
        {0, 0, 0, 0}, // 0
        {0, 0, 0, 0}, // 1
        {1, 0, 0, 0}, // 2
        {0, 1, 0, 0}, // 3
        {2, 0, 0, 0}, // 4
        {0, 0, 1, 0}, // 5
        {1, 1, 0, 0}, // 6
        {0, 0, 0, 1}, // 7
        {3, 0, 0, 0}, // 8
        {0, 2, 0, 0}, // 9
    };

    public String smallestNumber(String num, long t) {
        int[] need = new int[4];
        for (int i = 0; i < 4; i++) {
            while (t % PRIMES[i] == 0) {
                t /= PRIMES[i];
                need[i]++;
            }
        }
        if (t != 1) return "-1";

        int n = num.length();
        int[] base = pack(need);
        if (size(base) > n) return build(base);

        int[] total = new int[4];
        for (char ch : num.toCharArray()) {
            int d = ch - '0';
            for (int i = 0; i < 4; i++) total[i] += DF[d][i];
        }

        int firstZero = num.indexOf('0');
        if (firstZero == -1) {
            firstZero = n;
            if (isSubset(need, total)) return num;
        }

        int[] prefix = total.clone();
        for (int i = n - 1; i >= 0; i--) {
            int d = num.charAt(i) - '0';
            prefix = sub(prefix, DF[d]);
            int space = n - 1 - i;
            if (i > firstZero) continue;

            for (int bigger = d + 1; bigger < 10; bigger++) {
                int[] remaining = sub(sub(need, prefix), DF[bigger]);
                int[] fc = pack(remaining);
                if (size(fc) <= space) {
                    int ones = space - size(fc);
                    StringBuilder sb = new StringBuilder();
                    sb.append(num, 0, i);
                    sb.append((char) ('0' + bigger));
                    for (int k = 0; k < ones; k++) sb.append('1');
                    sb.append(build(fc));
                    return sb.toString();
                }
            }
        }

        // No same-length answer — extend by one digit
        int[] fc = pack(need);
        StringBuilder sb = new StringBuilder();
        int leadingOnes = n + 1 - size(fc);
        for (int k = 0; k < leadingOnes; k++) sb.append('1');
        sb.append(build(fc));
        return sb.toString();
    }

    private int[] sub(int[] a, int[] b) {
        int[] res = new int[4];
        for (int i = 0; i < 4; i++) res[i] = Math.max(0, a[i] - b[i]);
        return res;
    }

    private boolean isSubset(int[] a, int[] b) {
        for (int i = 0; i < 4; i++) if (a[i] > b[i]) return false;
        return true;
    }

    // packs remaining {2,3,5,7} factor counts into fewest / smallest digits
    // result index layout: [2,3,4,5,6,7,8,9] as counts of each digit
    private int[] pack(int[] cnt) {
        int c2 = cnt[0], c3 = cnt[1], c5 = cnt[2], c7 = cnt[3];
        int c8 = c2 / 3; c2 %= 3;
        int c9 = c3 / 2; c3 %= 2;
        int c4 = c2 / 2; c2 %= 2;
        int c6 = 0;
        if (c2 == 1 && c3 == 1) { c2 = 0; c3 = 0; c6 = 1; }
        if (c3 == 1 && c4 == 1) { c2 = 1; c6 = 1; c3 = 0; c4 = 0; }
        // order: digit2, digit3, digit4, digit5, digit6, digit7, digit8, digit9
        return new int[]{c2, c3, c4, c5, c6, c7, c8, c9};
    }

    private int size(int[] fc) {
        int s = 0;
        for (int v : fc) s += v;
        return s;
    }

    private String build(int[] fc) {
        StringBuilder sb = new StringBuilder();
        for (int digit = 2; digit <= 9; digit++) {
            int count = fc[digit - 2];
            for (int k = 0; k < count; k++) sb.append((char) ('0' + digit));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.smallestNumber("1234", 256));  // "1488"
        System.out.println(s.smallestNumber("12355", 50));  // "12355"
        System.out.println(s.smallestNumber("11111", 26));  // "-1"
    }
}