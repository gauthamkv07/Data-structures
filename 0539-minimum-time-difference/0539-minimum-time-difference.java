class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();

        int[] time = new int[n];

        int index = 0;
        for(String curr: timePoints) {
            String[] arr = curr.split(":");

            int hour = Integer.parseInt(arr[0]);
            int min = Integer.parseInt(arr[1]);

            time[index++] = hour * 60 + min;
        }

        Arrays.sort(time);

        int res = Integer.MAX_VALUE;

        for(int i = 1; i < n; i++) res = Math.min(res, time[i] - time[i-1]);

        return Math.min(res, 1440 - time[n-1] + time[0]);
    }
}