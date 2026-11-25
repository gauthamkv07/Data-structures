import java.util.*;

class Solution {
    static final long MOD = 1_000_000_007L;
    static final long P = 131;
    static final long INV_P = power(P, MOD - 2);   // modular inverse of P

    static long power(long b, long e) {
        long res = 1;
        b %= MOD;
        while (e > 0) {
            if ((e & 1) == 1) res = res * b % MOD;
            b = b * b % MOD;
            e >>= 1;
        }
        return res;
    }

    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;

        // shift values to be >= 1 so zeros/negatives don't break the hash
        int min = Integer.MAX_VALUE;
        for (int x : nums) min = Math.min(min, x);
        long[] val = new long[n];
        for (int i = 0; i < n; i++) val[i] = ((long) nums[i] - min + 1) % MOD;

        int l = 1, r = n;
        while (l < r) {
            int mid = (l + r) / 2;
            if (existsUnique(val, mid)) r = mid;   // try smaller
            else l = mid + 1;                       // need longer
        }
        return l;
    }

    private boolean existsUnique(long[] val, int curr) {
        int n = val.length;
        Map<Long, Integer> freq = new HashMap<>();

        // window 0: hash = val[0]*p^0 + val[1]*p^1 + ... + val[curr-1]*p^(curr-1)
        long hash = 0, pw = 1;
        for (int j = 0; j < curr; j++) {
            hash = (hash + val[j] * pw) % MOD;
            pw = pw * P % MOD;
        }
        long pHigh = power(P, curr - 1);   // weight of the newest element

        freq.merge(hash, 1, Integer::sum);

        // slide
        for (int i = 1; i <= n - curr; i++) {
            hash = ((hash - val[i - 1]) % MOD + MOD) % MOD;   // remove leaving element (weight p^0)
            hash = hash * INV_P % MOD;                         // shift every power down by one
            hash = (hash + val[i + curr - 1] * pHigh) % MOD;   // add entering element at p^(curr-1)
            freq.merge(hash, 1, Integer::sum);
        }

        for (int c : freq.values()) {
            if (c == 1) return true;
        }
        return false;
    }
}