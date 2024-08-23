class Solution {
    private int findGCD(int a, int b) {
        if(a == 0) return b;
        return findGCD(b % a, a);
    }

    public int[] simplify(int num, int den) {
        int gcd = Math.abs(findGCD(num, den));

        num /= gcd;
        den /= gcd;

        return new int[] { num, den };
    }

    public String fractionAddition(String expression) {
        int num = 0, den = 0, pn = Integer.MIN_VALUE, pd = Integer.MIN_VALUE, n = expression.length();

        for (int i = 0; i < expression.length(); i++) {
            int cn = 0, cd = 0;
            boolean isNegative = false;
            while (expression.charAt(i) != '/') {
                char c = expression.charAt(i);
                if (c == '-' || c == '+') {
                    i++;
                    if (c == '-')
                        isNegative = true;
                    continue;
                }
                cn = cn * 10;
                cn += c - '0';
                i++;
            }
            if (isNegative)
                cn *= -1;
            i++;
            while (i < n && expression.charAt(i) != '-' && expression.charAt(i) != '+') {
                char c = expression.charAt(i);
                cd = cd * 10;
                cd += c - '0';
                i++;
            }
            if (i != n)
                i -= 1;
            int[] nums = simplify(cn, cd);
            cn = nums[0];
            cd = nums[1];
            if (pn == Integer.MIN_VALUE) {
                pn = cn;
                pd = cd;
                continue;
            }
            cn = pn * cd + cn * pd;
            cd = pd * cd;
            nums = simplify(cn, cd);
            cn = nums[0];
            cd = nums[1];
            pn = cn;
            pd = cd;
        }

        return pn == 0 ? "0/1" : (String.valueOf(pn) + "/" + String.valueOf(pd));
    }
}