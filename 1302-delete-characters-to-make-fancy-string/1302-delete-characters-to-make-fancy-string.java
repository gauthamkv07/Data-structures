class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();

        int count = 0;
        char prev = '1';
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c != prev) {
                prev = c;
                count = 1;
            } else count++;

            if(count < 3) sb.append(c);
        }

        return sb.toString();
    }
}