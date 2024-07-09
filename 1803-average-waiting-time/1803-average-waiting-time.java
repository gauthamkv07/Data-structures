class Solution {
    public double averageWaitingTime(int[][] customers) {
        long sum = 0, curr = 0;

        for(int[] c: customers) {
            int arr = c[0], time = c[1];

            if(arr >= curr) {
                sum += time;
                curr = arr+time;
                continue;
            }

            sum += (curr - arr) + time;
            curr += time;
        }

        return (double) sum/ (double) customers.length;
    }
}