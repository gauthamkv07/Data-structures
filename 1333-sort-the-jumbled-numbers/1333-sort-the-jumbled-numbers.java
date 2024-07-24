class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        int[][] comb = new int[n][2];
        int[] res = new int[n];

        for(int i = 0; i < n; i++) {
            comb[i][0] = nums[i];

            int val = 0, mul = 1, num = nums[i];

            if(num == 0) {
                val = mapping[num];
                comb[i][1] = val;
                continue;
            }

            while(num > 0) {
                val += mul * mapping[num % 10];
                num = num/10;
                mul = mul * 10;
            }

            comb[i][1] = val;
        }

        Arrays.sort(comb, (a,b) -> Integer.compare(a[1],b[1]));

        for(int i = 0; i < n; i++) res[i] = comb[i][0];

        return res;
    }
}