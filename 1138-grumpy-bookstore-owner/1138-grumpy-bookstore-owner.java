class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int m) {
        int n = customers.length, ans = 0, max = 0, curr = 0;
        for(int i = 0; i < n; i++) {
            if(i-m >= 0 && grumpy[i-m] == 1) curr -= customers[i-m];
            if(grumpy[i] == 0) {
                ans += customers[i];
                continue;
            }
            curr += customers[i];
            System.out.println(curr + " " + i);
            max = Math.max(curr, max);
        }


        return ans + max;
    }
}