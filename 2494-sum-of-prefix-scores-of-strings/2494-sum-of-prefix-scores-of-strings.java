class TrieNode {

    int count;
    TrieNode[] children;

    public TrieNode() {
        count = 0;
        children = new TrieNode[26];

        for(int i = 0; i < 26; i++) children[i] = null;
    }

    public TrieNode getChild(int index) {
        return children[index];
    }

    public void setChild(int index, TrieNode trieNode) {
        children[index] = trieNode;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void incrementCount() {
        count++;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void addString(String word) {
        TrieNode crawler = root;

        for(char c: word.toCharArray()) {
            int index = c - 'a';

            if(crawler.getChild(index) == null) crawler.setChild(index, new TrieNode());
            crawler = crawler.getChild(index);
            crawler.incrementCount();
        }
    }

    public int getPrefixCount(String word) {
        TrieNode crawler = root;
        int count = 0;

        for(char c: word.toCharArray()) {
            int index = c - 'a';

            if(crawler.getChild(index) == null) break;
            crawler = crawler.getChild(index);
            count += crawler.getCount();
        }

        return count;
    }
}

class Solution {
    Trie trie;

    public Solution() {
        trie = new Trie();
    }

    public int[] sumPrefixScores(String[] words) {
        int n = words.length;

        int[] res = new int[n];

        for(String word: words) trie.addString(word);

        for(int i = 0; i < n; i++) res[i] = trie.getPrefixCount(words[i]);

        return res;
    }
}