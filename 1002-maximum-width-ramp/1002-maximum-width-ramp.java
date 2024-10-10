class Solution {
    public int maxWidthRamp(int[] nums) {
        List<Integer> list = new ArrayList<>();

        int res = 0, n = nums.length;

        for(int i = 0; i < n; i++) {
            if(list.size() == 0 || nums[i] < nums[list.get(list.size() - 1)]) list.add(i);
            else {
                int l = 0, r = list.size() - 1, mid = 0;

                while(l < r) {
                    mid = l + (r-l)/2;
                    if(nums[list.get(mid)] > nums[i]) l = mid + 1;
                    else r = mid;
                }

                res = Math.max(res, i - list.get(l));
            }
        }
        return res;
    }
}