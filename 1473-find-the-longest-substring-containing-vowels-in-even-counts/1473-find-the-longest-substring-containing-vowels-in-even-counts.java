class Solution {
    public int findTheLongestSubstring(String s) {
        int[] count = new int[5];
        String vowels = "aeiou";
        int index = 0, res = 0;

        int[] map = new int[32];
        Arrays.fill(map, -1);

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(vowels.indexOf(c) != -1) index ^= 1 << vowels.indexOf(c);
            if(map[index] == -1 && index != 0) map[index] = i;
            res = Math.max(res, i - map[index]);
        }

        return res;
    }
}