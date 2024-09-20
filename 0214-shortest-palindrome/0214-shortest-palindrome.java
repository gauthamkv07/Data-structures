class Solution {
    public String shortestPalindrome(String s) {
        String revString = new StringBuilder(s).reverse().toString();
        String combString = s  + "#" + revString;

        int palindromeLength = kmp(combString);
        StringBuilder suffix = new StringBuilder(s.substring(palindromeLength)).reverse();
        return suffix.append(s).toString();
    }

    private int kmp(String s) {
        int[] prefixTable = new int[s.length()];

        int len = 0;
        for(int i = 1; i < prefixTable.length; i++) {
            while(len > 0 && s.charAt(i) != s.charAt(len)) len = prefixTable[len-1];
            if(s.charAt(i) == s.charAt(len)) len++;
            prefixTable[i] = len;
        }

        return prefixTable[s.length() - 1];
    }
}