class TrieNode {
    String word;
    TrieNode[] children;

    public TrieNode() {
        children = new TrieNode[26];

        for (int i = 0; i < 26; i++)
            children[i] = null;
    }

    public TrieNode getChild(int index) {
        return children[index];
    }

    public void setChild(int index, TrieNode node) {
        children[index] = node;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public TrieNode getRoot() {
        return root;
    }

    public void addString(String s) {
        TrieNode crawler = root;

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (crawler.getChild(index) == null)
                crawler.setChild(index, new TrieNode());
            crawler = crawler.getChild(index);
        }

        crawler.setWord(s);
    }

}

class Solution {
    Trie trie;
    List<String> res;

    public Solution() {
        trie = new Trie();
        res = new ArrayList<>();
    }

    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words)
            trie.addString(word);
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                dfs(board, i, j, trie.getRoot());
        return res;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node) {
        int c = board[i][j] - 'a';
        if (c < 0 || node.getChild(c) == null)
            return;

        node = node.getChild(c);
        if (node.getWord() != null) {
            res.add(node.getWord());
            node.setWord(null); // Avoid duplicates
        }

        board[i][j] = '#'; // Mark as visited
        if (i - 1 >= 0)
            dfs(board, i - 1, j, node);
        if (i + 1 < board.length)
            dfs(board, i + 1, j, node);
        if (j - 1 >= 0)
            dfs(board, i, j - 1, node);
        if (j + 1 < board[0].length)
            dfs(board, i, j + 1, node);
        board[i][j] = (char) (c + 'a'); // Unmark
    }

}