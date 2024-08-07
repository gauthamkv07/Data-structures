class Solution {
    private static final String[] ones = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
            "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
            "Nineteen" };

    private static final String[] belowHundred = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
            "Eighty",
            "Ninety" };

    private static final String[] thousands = { "", "Thousand", "Million", "Billion" };

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";

        StringBuilder res = new StringBuilder();
        int gp = 0;

        while (num > 0) {
            if (num % 1000 != 0) {
                StringBuilder sb = new StringBuilder();
                int curr = num % 1000;

                if (curr >= 100) {
                    sb.append(ones[curr / 100]).append(" Hundred ");
                    curr %= 100;
                }

                if (curr >= 20) {
                    sb.append(belowHundred[curr / 10]).append(" ");
                    curr %= 10;
                }

                if (curr > 0)
                    sb.append(ones[curr]).append(" ");

                sb.append(thousands[gp]).append(" ");

                res.insert(0, sb);
            }
            num /= 1000;
            gp++;
        }

        return res.toString().trim();
    }
}