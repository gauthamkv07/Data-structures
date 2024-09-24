class TrieNode {
    TrieNode[] children;

    public TrieNode() {
        children = new TrieNode[10];

        for (int i = 0; i < 10; i++)
            children[i] = null;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public List<Integer> getList(int num) {
        List<Integer> list = new ArrayList<>();
        while (num > 0) {
            list.add(num % 10);
            num /= 10;
        }
        Collections.reverse(list);
        return list;
    }

    public void addNumber(int number) {
        List<Integer> list = getList(number);

        TrieNode crawler = root;

        for(int num: list) {
            if(crawler.children[num] == null) crawler.children[num] = new TrieNode();
            crawler = crawler.children[num];
        }
    }

    public int getLongestCommonPrefixLength(int number){
        List<Integer> list = getList(number);

        TrieNode crawler = root;
        int count = 0;

        for(int num: list) {
            if(crawler.children[num] == null) return count;
            count++;
            crawler = crawler.children[num];
        }

        return count;
    }
}

class Solution {

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie trie = new Trie();

        int res = 0;

        for(int num: arr1) trie.addNumber(num);

        for(int num: arr2) res = Math.max(res, trie.getLongestCommonPrefixLength(num));

        return res;
    }
}