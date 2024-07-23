class Solution {
    public int[] frequencySort(int[] nums) {
        int[] freq = new int[201];
        for(int num: nums) freq[num+100]++;

        List<Integer>[] list = new ArrayList[101];

        for(int i = 200; i >= 0; i--) {
            int fr = freq[i];
            int val = i-100;
            if(list[fr] == null) list[fr] = new ArrayList<>();
            list[fr].add(val);
        }

        int[] res = new int[nums.length];
        for(int i = 1, j = 0; i <= 100; i++) if(list[i] != null) for(int num: list[i]) for(int k = 0; k < i; k++) res[j++] = num;

        return res;
    }
}