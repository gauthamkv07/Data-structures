class Solution {
    public String reorganizeString(String s) {
        int[] count = new int[26];
        int maxCount = 0, n = s.length();
        char ch = 'a';

        for(char c: s.toCharArray()) {
            if(++count[c-'a'] > maxCount) {
                maxCount = count[c-'a'];
                ch = c;
            }
        }

        if(maxCount > (n+1)/2) return "";
        char[] res = new char[n];

        int index = 0;
        while(maxCount-- > 0) {
            res[index] = ch;
            count[ch-'a']--;
            index += 2;
            if(index >= n) index = 1;
        }
        
        for(int i = 0; i < 26; i++) {
            while(count[i]-- > 0) {
                res[index] = (char) (i + 'a');
                index += 2;
                if(index >= n) index = 1;
            }
        }

        return String.valueOf(res);
    }
}