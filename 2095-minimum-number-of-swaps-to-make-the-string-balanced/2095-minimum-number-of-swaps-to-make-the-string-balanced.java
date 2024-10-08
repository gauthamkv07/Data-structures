class Solution {
    public int minSwaps(String s) {
        int open = 0, res = 0;

        for(char c: s.toCharArray()) {
            if(c == '[') open++;
            else open--;

            if(open < 0) res = Math.max(res, Math.abs(open));
        }

        return (res+1)/2;
    }
}