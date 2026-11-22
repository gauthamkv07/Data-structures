class Solution {
    public boolean checkString(String s) {
        boolean isbpresent = false;

        for(char c: s.toCharArray()) {
            if(c == 'a' && isbpresent) return false;
            if(c == 'b') isbpresent = true;
        }

        return true;
    }
}