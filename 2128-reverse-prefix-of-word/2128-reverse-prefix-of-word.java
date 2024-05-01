class Solution {
    public String reversePrefix(String word, char ch) {
        int index = -1;
        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == ch) {
                index = i;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = index; i >=0; i--) sb.append(word.charAt(i));
        return index == -1? word: (sb.toString() + word.substring(index+1, word.length()));
    }
}