class Solution {
    public int minimumPushes(String word) {
        int[] count = new int[26];
        for(char c: word.toCharArray()) count[c-'a']++;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(b,a));

        for(int c: count) if(c != 0) pq.offer(c);

        int num = 8, res = 0, n = 1;

        while(!pq.isEmpty()) {
            if(num == 0) {
                num = 8;
                n++;
            }
            res += pq.poll() * n;
            num--;
        }

        return res;
    }
}