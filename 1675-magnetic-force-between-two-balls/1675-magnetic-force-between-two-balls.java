class Solution {
    public boolean cntballs(int x, int[] arr, int m) {
        int ballsplaced = 1, curr = arr[0];

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] - curr >= x) {
                ballsplaced++;
                curr = arr[i];
            }
        }

        return ballsplaced >= m;
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int n = position.length, ans = -1;
        int l = 1, r = position[n-1];

        while(l <= r) {
            int mid = l + (r-l)/2;
            if(cntballs(mid, position,m)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }
}