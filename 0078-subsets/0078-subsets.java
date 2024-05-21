class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        int n = nums.length;

        list.add(new ArrayList<>());

        for(int i = 0; i < n; i++) {
            int size = list.size();
            
            for(int j = 0; j < size; j++) {
                curr = list.get(j);
                curr = new ArrayList<>(curr);
                curr.add(nums[i]);
                list.add(new ArrayList<>(curr));
            }
        }

        return list;
    }
}