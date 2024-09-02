class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int i = 0, n = chalk.length;

        long sum = 0;

        for(int c: chalk) sum += (long) c;

        sum = (long)k % (long) sum;

        if(sum == 0) return i;

        for(; i < n; i++) {
            if(chalk[i] > sum) return i;
            sum -= chalk[i];
        }

        return i;
    }
}