class Solution {
    public int candy(int[] ratings) {
        int res = 0, n = ratings.length, curr = 1;

        int[] lr = new int[n], rr = new int[n];

        Arrays.fill(lr,1);
        Arrays.fill(rr,1);

        for(int i = 1; i < n; i++) if(ratings[i] > ratings[i-1]) lr[i] = lr[i-1] + 1;
        for(int i = n-2; i >= 0; i--) if(ratings[i] > ratings[i+1]) rr[i] = rr[i+1] + 1;

        for(int i = 0; i < n; i++) res += Math.max(lr[i], rr[i]);

        return res;
    }
}