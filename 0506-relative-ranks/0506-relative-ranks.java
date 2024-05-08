class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(b[0],a[0]));
        int n = score.length;
        String[] res = new String[n];
        for(int i = 0; i < n; i++) pq.offer(new int[]{score[i], i});
        int i = 1;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int index = curr[1];
            if(i == 1) res[index] = "Gold Medal";
            else if(i == 2) res[index] = "Silver Medal";
            else if(i == 3) res[index] = "Bronze Medal";
            else res[index] = String.valueOf(i);
            i++;
        }
        return res;
    }
}