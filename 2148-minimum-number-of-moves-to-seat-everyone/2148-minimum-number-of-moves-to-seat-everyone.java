class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        int m = Math.max(findMax(seats), findMax(students));

        int[] diff = new int[m];

        for(int s: seats) diff[s-1]++;
        for(int s: students) diff[s-1]--;

        int moves = 0;
        int unmatched = 0;

        for(int d: diff) {
            moves += Math.abs(unmatched);
            unmatched += d;
        }

        return moves;
    }

    public int findMax(int[] nums) {
        int max = -1;
        for(int num: nums) max = Math.max(num, max);
        return max;
    }
}