class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int res = 0, i = -1;

        for(int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            i = Math.max(i, map.getOrDefault(c, -1));
            res = Math.max(res, j - i);
            map.put(c, j);
        }

        return res;
    }
}