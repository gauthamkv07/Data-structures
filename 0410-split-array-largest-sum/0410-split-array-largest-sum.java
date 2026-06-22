class Solution {
    private boolean canSplit(int[] nums, int max, int k) {
        int sum = 0;
        int count = 1;

        for(int num: nums) {
            if((sum + num) > max) {
                sum = num;
                count++;
            } else {
                sum += num;
            }
        }

        return count <= k;
    }

    public int splitArray(int[] nums, int k) {
        int min = Integer.MIN_VALUE, max = 0;

        for(int num: nums) {
            min = Math.max(num, min);
            max += num;
        }

        while(min < max) {
            int mid = min + (max - min)/2;

            if(canSplit(nums, mid, k)) {
                max = mid;
            } else min = mid + 1;
        }

        return min;
    }
}