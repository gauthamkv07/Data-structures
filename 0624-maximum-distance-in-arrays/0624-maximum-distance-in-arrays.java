class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        if(arrays.size() == 1) return 0;

        int n = arrays.size();
        int min = arrays.get(0).get(0), max = arrays.get(0).get(arrays.get(0).size() - 1), res = Integer.MIN_VALUE;

        for(int i = 1; i < n; i++) {
            int cm = arrays.get(i).get(0), cma = arrays.get(i).get(arrays.get(i).size() - 1);
            res = Math.max(res, Math.abs(max - cm));
            res = Math.max(res, Math.abs(min - cma));
            min = Math.min(cm,min);
            max = Math.max(cma, max);
        }

        return res;
    }
}