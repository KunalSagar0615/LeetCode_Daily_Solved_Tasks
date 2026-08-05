import java.util.*;

class Solution {
    public String smallestPalindrome(String s, int k) {
        int[] counts = new int[26];
        for (char ch : s.toCharArray()) {
            counts[ch - 'a']++;
        }

        char midChar = '\0';
        int[] halfCounts = new int[26];
        for (int i = 0; i < 26; i++) {
            halfCounts[i] = counts[i] / 2;
            if (counts[i] % 2 == 1) {
                midChar = (char) ('a' + i);
            }
        }

        int halfLen = 0;
        for (int c : halfCounts) halfLen += c;

        long cap = (long) k + 1;
        long total = cappedMultinomial(halfCounts, cap);
        if (total < k) return "";

        StringBuilder half = new StringBuilder();
        long rank = k;
        int[] remaining = halfCounts.clone();

        for (int pos = 0; pos < halfLen; pos++) {
            for (int ci = 0; ci < 26; ci++) {
                if (remaining[ci] == 0) continue;
                remaining[ci]--;
                long cnt = cappedMultinomial(remaining, rank + 1);
                if (cnt >= rank) {
                    half.append((char) ('a' + ci));
                    break;
                }
                rank -= cnt;
                remaining[ci]++;
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(half);
        if (midChar != '\0') result.append(midChar);
        result.append(half.reverse());
        return result.toString();
    }

    // Number of distinct arrangements of the multiset described by counts,
    // saturating at `cap` once the true value would meet/exceed it.
    private long cappedMultinomial(int[] counts, long cap) {
        int remaining = 0;
        for (int c : counts) remaining += c;

        long result = 1;
        for (int cnt : counts) {
            if (cnt == 0) continue;
            result *= nCr(remaining, cnt, cap);
            remaining -= cnt;
            if (result >= cap) return cap;
        }
        return result;
    }

    // Computes C(n, r) but stops early (returns cap) once it would meet/exceed cap.
    private long nCr(int n, int r, long cap) {
        if (r > n - r) r = n - r; // symmetry, keeps r small
        long result = 1;
        for (int i = 0; i < r; i++) {
            result = result * (n - i) / (i + 1);
            if (result >= cap) return cap;
        }
        return result;
    }
}