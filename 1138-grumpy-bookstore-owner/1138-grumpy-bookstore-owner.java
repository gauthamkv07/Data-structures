class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int m) {
        int n = customers.length, ans = 0;
        for(int i = 0; i < n; i++) if(grumpy[i] == 0) ans += customers[i];

        int max = 0, curr = 0;
        for(int i = 0; i < m; i++) if(grumpy[i] == 1) curr += customers[i];
        max = curr;
        for(int i = m; i < n; i++) {
            if(grumpy[i] == 1) curr += customers[i];
            if(grumpy[i-m] == 1) curr -= customers[i-m];
            max = Math.max(curr, max);
        }

        return ans + max;
    }
}