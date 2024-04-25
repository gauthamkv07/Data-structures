class Solution {
    List<Long> lcmList;

    public long findKthSmallest(int[] coins, int k) {
        lcmList = new ArrayList<>();
        int n = coins.length;
        int allOnes = (1 << n) - 1;

        for(int mask = 1; mask <= allOnes; mask++) {
            long currLCM = 1;

            for(int i = 0; i < n; i++) if((mask & (1<<i)) > 0) currLCM = lcm(currLCM, coins[i]);

            long multiplier = Integer.bitCount(mask) % 2 == 1?1: -1;
            lcmList.add(multiplier * currLCM);
        }

        
        long l = 1, r = Long.MAX_VALUE;

        while(l < r) {
            long mid = l + (r-l)/2;
            long count = getCount(mid);
            if(count < k) l = mid + 1;
            else r = mid;
        }

        return l;
    }

    public long getCount(long target) {
        long count = 0;
        for(long lcm: lcmList) count += target/lcm;
        return count;
    }

    public long gcd(long a, long b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    public long lcm(long a, long b) {
        return a * (b/gcd(a,b));
    }
}