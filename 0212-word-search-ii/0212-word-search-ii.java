class Solution {

    class TrieNode {
        TrieNode[] children;
        String word;

        public TrieNode() {
            children = new TrieNode[26];
            word = null;
            for(TrieNode child: children) child = null;
        }
    }

    class Trie {
        TrieNode root;
        List<String> result;

        public Trie() {
            root = new TrieNode();
            result = new ArrayList<>();
        }

        public void buildTrie(String[] words) {
            for(String word: words) {
                TrieNode crawler = root;

                for(int i = 0; i < word.length(); i++) {
                    int index = word.charAt(i) - 'a';
                    if(crawler.children[index] == null) crawler.children[index] = new TrieNode();
                    crawler = crawler.children[index];
                }

                crawler.word = word;
            }
        }

        public void dfs(char[][] board, int i, int j, TrieNode crawler) {
            char c = board[i][j];

            if(crawler.children[c - 'a'] == null) return;
            crawler = crawler.children[c - 'a'];
            if(crawler.word != null) {
                result.add(crawler.word); 
                crawler.word = null;
            }

            board[i][j] = '#';
            if(i - 1 >= 0 && board[i-1][j] != '#') dfs(board, i-1, j, crawler);
            if(j - 1 >= 0 && board[i][j-1] != '#') dfs(board, i, j-1, crawler);
            if(i + 1 < board.length && board[i+1][j] != '#') dfs(board, i+1, j, crawler);
            if(j + 1 < board[0].length && board[i][j+1] != '#') dfs(board, i, j+1, crawler);
            board[i][j] = c;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        trie.buildTrie(words);
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++) for(int j = 0; j < n; j++) trie.dfs(board, i, j, trie.root);
        return trie.result;
    }
}