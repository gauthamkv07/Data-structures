class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;

        int[][] comb = new int[n][2];

        for(int i = 0; i < n; i++) {
            comb[i][0] = capital[i];
            comb[i][1] = profits[i];
        }

        Arrays.sort(comb, (a,b)->Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Integer.compare(b[1],a[1]));

        int i = 0;

        while(--k >= 0) {
            while(i < n && comb[i][0] <= w) pq.offer(comb[i++]);
            if(pq.isEmpty()) return w;
            w += pq.poll()[1];
        }

        return w;
    }
}