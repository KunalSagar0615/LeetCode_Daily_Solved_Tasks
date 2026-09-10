class Solution {
    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);

        for (int m = 63; m >= 2; m--) {
            long low = 2;
            long high = (long) Math.pow(num, 1.0 / m) + 1;

            while (low <= high) {
                long base = low + (high - low) / 2;

                long sum = 1;
                long power = 1;

                for (int i = 1; i <= m; i++) {
                    if (power > (num - 1) / base) {
                        sum = num + 1;
                        break;
                    }

                    power *= base;
                    sum += power;

                    if (sum > num) break;
                }

                if (sum == num) {
                    return String.valueOf(base);
                }

                if (sum < num) {
                    low = base + 1;
                } else {
                    high = base - 1;
                }
            }
        }

        return String.valueOf(num - 1);
    }
}