class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length, res = 0, prefix = 0, count, total;
        Map<Integer, Integer> countMap = new HashMap<>(), totalMap = new HashMap<>();
        countMap.put(0,1);
        for(int i = 0; i < n; i ++) {
            prefix ^= arr[i];
            count = countMap.getOrDefault(prefix, 0);
            total = totalMap.getOrDefault(prefix, 0);
            res += count * i - total;
            countMap.put(prefix, count+1);
            totalMap.put(prefix, total+i+1);
        }
        return res;
    }
}