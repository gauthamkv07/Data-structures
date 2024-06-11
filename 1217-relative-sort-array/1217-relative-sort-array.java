class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] cnt = new int[10010];
        int[] res = new int[arr1.length];

        for(int i: arr1) cnt[i]++;

        int j = 0;
        for(int i = 0; i < arr2.length; i++) while(cnt[arr2[i]]-- > 0) res[j++] = arr2[i];

        for(int i = 0; i < 1001; i++) while(cnt[i]-- > 0) res[j++] = i;

        return res;
    }
}