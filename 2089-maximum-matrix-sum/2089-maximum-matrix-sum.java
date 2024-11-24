class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int count = 0, min = Integer.MAX_VALUE;
        long sum = 0;

        for (int[] row : matrix) {
            for (int val : row) {
                if (val < 0)
                    count--;
                min = Math.min(min, Math.abs(val));
                sum += (long) Math.abs(val);
            }
        }

        return count % 2 == 0 ? sum : sum - 2 * (long) min;
    }
}