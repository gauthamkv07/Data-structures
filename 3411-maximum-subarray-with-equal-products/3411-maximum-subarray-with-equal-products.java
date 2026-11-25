class Solution {
    public int maxLength(int[] nums) {
        int res = 2, n = nums.length;
        int prodVal = nums[0];
        int start = 0, end = 1;

        while(end < n) {
            while(gcd(prodVal, nums[end]) > 1) prodVal /= nums[start++];
            res = Math.max(res, end - start + 1);
            prodVal *= nums[end++];
        }

        return res;
    }

    private int gcd(int a, int b) {
        while(b != 0) {
            int temp = a;
            a = b;
            b = temp % a;
        }
        return a;
    }
}