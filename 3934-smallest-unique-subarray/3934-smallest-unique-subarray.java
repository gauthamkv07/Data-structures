class Solution {
    final long mod = 1000000007L;
    final long base = 911382323L;

    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;

        int l = 1, r = n;

        long[] hash = new long[n+1];
        long[] power = new long[n+1];
        power[0] = 1;

        for(int i = 0; i < n; i++) {
            hash[i + 1] = (hash[i] * base + nums[i]) % mod;
            power[i + 1] = (power[i] * base) % mod;
        }

        while(l < r) {
            int mid = (l + r)/2;
            if(isSmallUniquePossible(hash, power, mid, n)) r = mid;
            else l = mid + 1;
        }

        return l;
    }

    private boolean isSmallUniquePossible(long[] hash ,long[] power ,int len, int n) {
        Map<Long, Integer> map = new HashMap<>();

        for(int i = 0; i + len <= n; i++) {
            int r = i + len;
            long key = ((hash[r] - ((hash[i] * power[len]) % mod)) + mod)  % mod;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for(int cnt: map.values()) if(cnt == 1) return true;

        return false;
    }
}