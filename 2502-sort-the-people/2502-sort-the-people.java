class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = heights.length;
        int[][] comb = new int[n][2];
        for(int i = 0; i < n; i++) {
            comb[i][0] = heights[i];
            comb[i][1] = i;
        }
        Arrays.sort(comb, (a,b) -> Integer.compare(b[0],a[0]));

        String[] res = new String[n];

        for(int i = 0; i < n; i++) res[i] = names[comb[i][1]];

        return res;
    }
}