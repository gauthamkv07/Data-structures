class Solution {
    public int countSeniors(String[] details) {
        int res = 0;
        for(String detail: details) res += Integer.valueOf(detail.substring(11,13)) > 60?1:0;
        return res;
    }
}