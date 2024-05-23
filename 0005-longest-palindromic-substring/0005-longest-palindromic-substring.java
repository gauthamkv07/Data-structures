class Solution {
    int n;

    public String longestPalindrome(String s) {
        n = s.length();
        String res = "";

        for(int i = 0; i < n; i++) {
            String even = findMaxPalin(s,i,i+1);
            String odd = findMaxPalin(s, i, i);
            if(res.length() < even.length()) res = even;
            if(res.length() < odd.length()) res = odd;
        }

        return res;
    }

    public String findMaxPalin(String s, int i, int j) {
        while(i >= 0 && j < n && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }

        return s.substring(i+1, j);
    }
}