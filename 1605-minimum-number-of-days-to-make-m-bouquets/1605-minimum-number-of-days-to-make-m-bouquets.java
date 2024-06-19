class Solution {
    public int bloom(int[] arr, int k, int day) {
        int bouquets = 0, curr = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] <= day) {
                curr++;
                if(curr == k) {
                    bouquets++;
                    curr = 0;
                }
            } else {
                curr = 0;
            }
        }
        return bouquets;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length, max = 0, bouquets = 0, days = Integer.MAX_VALUE;
        if(k * m > n) return -1;
        for(int b: bloomDay) max = Math.max(b, max);
        int l = 1, r = max;
        while(l <= r) {
            int mid = l + (r-l)/2;
            bouquets = bloom(bloomDay, k, mid);
            if(bouquets >= m) days = Math.min(days, mid);
            if(bouquets < m) l = mid + 1;
            else r = mid-1;
        }
        return days == Integer.MAX_VALUE?-1:days;
    }
}