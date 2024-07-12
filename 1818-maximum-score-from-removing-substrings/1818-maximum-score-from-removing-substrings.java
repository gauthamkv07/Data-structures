class Solution {
    public int maximumGain(String s, int x, int y) {
        if(x < y) {
            y = x + y;
            x = y - x;
            y = y - x;
            s = new StringBuilder(s).reverse().toString();
        }

        int a = 0, b = 0, res = 0;
        for(char c: s.toCharArray()) {
            if(c == 'a') a++;
            else if(c == 'b') {
                if(a > 0) {
                    a--;
                    res += x;
                } else b++;
            } else {
                res += Math.min(a,b) * y;
                a = 0;
                b = 0;
            }
        }

        res += Math.min(a,b) * y;
        return res;
    }
}