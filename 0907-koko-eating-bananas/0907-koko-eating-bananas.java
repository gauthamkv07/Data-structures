class Solution {
    private int calcHours(int[] piles, int k) {
        int h = 0;
        for (int pile : piles)
            h += (pile + k - 1) / k;
        return h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = Integer.MIN_VALUE;

        for (int pile : piles) 
            r = Math.max(r, pile);

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (calcHours(piles, mid) > h)
                l = mid + 1;
            else
                r = mid;
        }

        return l;
    }
}