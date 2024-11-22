class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int res = 0;

        HashMap<String, Integer> map = new HashMap<>();

        for (int[] row : matrix) {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();

            for (int cell : row) {
                // Build the pattern and its complement
                sb1.append(cell);
                sb2.append(1 - cell);
            }

            String pattern = sb1.toString();
            String complement = sb2.toString();

            // Update counts in the map
            map.put(pattern, map.getOrDefault(pattern, 0) + 1);
            map.put(complement, map.getOrDefault(complement, 0) + 1);

            // Update the result with the maximum count
            res = Math.max(res, map.get(pattern));
        }

        return res;
    }
}
