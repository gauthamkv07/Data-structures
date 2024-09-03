class Solution {
    public int getLucky(String s, int k) {
        int num = 0;
        for (char c : s.toCharArray()) {
            int val = c - 'a' + 1;
            while (val > 0) {
                num += val % 10;
                val /= 10;
            }
        }

        while (--k > 0) {
            int newNum = 0;
            while (num > 0) {
                newNum += num % 10;
                num /= 10;
            }
            num = newNum;
        }

        return num;
    }
}