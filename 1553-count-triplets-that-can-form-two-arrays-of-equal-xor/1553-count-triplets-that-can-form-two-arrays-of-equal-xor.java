class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length, res = 0;
        int[] prefix = new int[n+1];
        for(int i = 1; i <= n; i++) prefix[i] = prefix[i-1] ^ arr[i-1];
        for(int i = 0; i < n; i++) for(int j = i+1; j <= n; j++) if(prefix[j] == prefix[i]) res+=j-i-1;
        return res;
    }
}