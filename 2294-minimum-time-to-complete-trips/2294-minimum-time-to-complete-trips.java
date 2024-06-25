class Solution {
    public long binarySearch(long s, int[] time) {
        long sum = 0;
        for(int t: time) sum += s/(long)t;
        return sum;
    }

    public long minimumTime(int[] time, int totalTrips) {
        long l = Long.MAX_VALUE, r = Long.MAX_VALUE;

        for(int t: time) l = Math.min((long) t, l);

        r = l * totalTrips;
        while(l < r) {
            long mid = l + (r-l)/2;

            if(binarySearch(mid, time) < totalTrips) l = mid + 1;
            else r = mid; 
        }

        return l;
    }
}