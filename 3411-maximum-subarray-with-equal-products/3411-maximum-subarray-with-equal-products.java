class Solution {
    public int maxLength(int[] nums) {
        int res = 2, n = nums.length;

        for(int i = 0; i < n - 1; i++) {
            long prodVal = nums[i];
            long gcdVal = nums[i];
            long lcmVal = nums[i];
            for(int j = i + 1; j < n; j++) {
                prodVal *= nums[j];
                gcdVal = gcd(gcdVal, nums[j]);
                lcmVal = (lcmVal * nums[j])/(gcd(lcmVal, nums[j]));
                if(prodVal > lcmVal * gcdVal) break;
                res = Math.max(res, j - i + 1);
            }
        }

        return res;
    }

    private long gcd(long a, long b) {
        while(b != 0) {
            long temp = a;
            a = b;
            b = temp % a;
        }
        return a;
    }
}