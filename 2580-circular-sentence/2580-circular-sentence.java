class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] list = sentence.split("\\s+");
        int n = list.length;

        for(int i = 1; i < n; i++) if(list[i-1].charAt(list[i-1].length() - 1) != list[i].charAt(0)) return false;

        return list[n-1].charAt(list[n-1].length() - 1) == list[0].charAt(0);
    }
}