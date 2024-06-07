class Solution {
    class Trie{
        boolean isEndOfWord;
        Trie[] children;

        Trie() {
            children = new Trie[26];
            for(int i = 0; i < 26; i++) children[i] = null;
            isEndOfWord = false;
        }

        public void insert(String word) {
            int i = 0;
            Trie crawl = root;
            while(i < word.length()) {
                int index = word.charAt(i++) - 'a';
                if(crawl.children[index] == null)crawl.children[index] = new Trie();
                crawl = crawl.children[index];
            }
            crawl.isEndOfWord = true;
        }

        public String getRoot(String word) {
            int i = 0;
            Trie crawl = root;
            StringBuilder sb = new StringBuilder();
            while(i < word.length()) {
                int index = word.charAt(i) - 'a';
                sb.append(word.charAt(i++));
                if(crawl.children[index] == null) return word;
                crawl = crawl.children[index];
                if(crawl.isEndOfWord) return sb.toString();
            }
            return word;
        }
    }

     Trie root;

    public String replaceWords(List<String> dictionary, String sentence) {
        root = new Trie();
        for(String word: dictionary) root.insert(word);
        String[] split = sentence.split("\\s+");
        for(int i = 0; i < split.length; i++) split[i] = root.getRoot(split[i]);
        return String.join(" ", split);
    }
}