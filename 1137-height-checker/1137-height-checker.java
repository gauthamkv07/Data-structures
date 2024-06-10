class Solution {
    public int heightChecker(int[] heights) {
        int n = heights.length;
        int[] expected = Arrays.copyOf(heights, n);
        Arrays.sort(expected);
        int ans = 0;
        for(int  i = 0; i < n; i++) if(expected[i] != heights[i]) ans++;
        return ans;
    }
}