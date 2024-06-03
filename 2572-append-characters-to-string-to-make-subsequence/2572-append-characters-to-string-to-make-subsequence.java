class Solution {
    public int appendCharacters(String s, String t) {
        int i = 0;
        for(char c: s.toCharArray()) {
            if(t.charAt(i) == c) i++;
            if(i == t.length()) break;
        }
        return t.length() - i;
    }
}