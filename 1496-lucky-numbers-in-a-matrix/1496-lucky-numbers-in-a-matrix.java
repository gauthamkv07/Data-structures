class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        int[] min = new int[m];
        int[] max = new int[n];
        Arrays.fill(min, Integer.MAX_VALUE);

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int curr = matrix[i][j];
                min[i] = Math.min(curr, min[i]);
                max[j] = Math.max(curr, max[j]);
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int curr = matrix[i][j];
                if(curr == min[i] && curr == max[j]) list.add(curr);
            }
        }

        return list;
    }
}