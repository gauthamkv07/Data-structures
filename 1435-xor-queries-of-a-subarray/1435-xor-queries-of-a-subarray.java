class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;

        int[] prefix = new int[n+1];

        for(int i = 1; i <= n; i++) prefix[i] = prefix[i-1] ^ arr[i-1];

        int[] res = new int[queries.length];

        int index = 0;

        for(int[] query: queries) {
            int i = query[0], j = query[1];
            res[index++] = prefix[j+1] ^ prefix[i];
        }

        return res;
    }
}