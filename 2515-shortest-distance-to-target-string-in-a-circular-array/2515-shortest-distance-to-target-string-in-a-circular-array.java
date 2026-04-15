class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length, res = Integer.MAX_VALUE;
        boolean found = false;

        for(int i = 0; i < n; i++) {
            if(target.equals(words[i])) {
                int pos = i;

                int first = 0, second = 0;

                first = Math.abs(pos - startIndex);

                second = n - Math.max(startIndex, pos) + Math.min(startIndex, pos);
                
                int curr = Math.min(first, second);

                res = Math.min(curr, res);
            }
        }

        return res == Integer.MAX_VALUE? -1: res;
    }
}