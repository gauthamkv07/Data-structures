class Solution {
    public String clearStars(String s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] != b[0]?Integer.compare(a[0], b[0]):Integer.compare(b[1], a[1]));
    
        for(int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            if(c == '*' && !pq.isEmpty()) pq.poll();
            else pq.add(new int[]{c-'a', i}); 
        }

        PriorityQueue<int[]> pq2 = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        while(!pq.isEmpty()) pq2.add(pq.poll());

        StringBuilder sb = new StringBuilder();

        while(!pq2.isEmpty()) sb.append((char) (pq2.poll()[0] + 'a'));

        return sb.toString();
    }
}