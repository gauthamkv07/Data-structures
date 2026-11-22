class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length, idx = 0;

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] bucket = new List[n+1];
        int[] res = new int[k];

        for(int num: nums) map.put(num, map.getOrDefault(num,0) + 1);

        for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if(bucket[count] == null) bucket[count] = new ArrayList<>();
            bucket[count].add(num);
        }

        for(int i = n; i > 0 && idx < k; i--) {
            if(bucket[i] == null) continue;
            for(int num: bucket[i]) {
                res[idx++] = num;
                if(idx == k) break;
            }
        }

        return res;
    }
}