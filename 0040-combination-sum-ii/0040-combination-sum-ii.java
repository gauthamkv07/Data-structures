class Solution {
    List<List<Integer>> res;
    List<Integer> cur;
    int n, target;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        cur = new ArrayList<>();
        n = candidates.length;
        this.target = target;
        Arrays.sort(candidates);
        bc(candidates, 0, 0);
        return res;
    }

    public void bc(int[] candidates, int sum, int start){
        if(sum > target) return;
        if(sum == target) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i = start; i < n; i++) {
            if(i > start && candidates[i] == candidates[i-1]) continue;
            cur.add(candidates[i]);
            bc(candidates, sum + candidates[i], i+1);
            cur.remove(cur.size()-1);
        } 
    }
}