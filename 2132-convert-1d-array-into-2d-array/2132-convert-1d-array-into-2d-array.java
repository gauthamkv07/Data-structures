class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(m * n != original.length) return new int[][]{};

        int[][] res = new int[m][n];

        int a = 0, b = 0;
        for(int i = 0; i < original.length; i++) {
            res[a][b++] = original[i];
            if(b == original.length/m) {
                a++;
                b = 0;
            }
        }

        return res;
    }
}