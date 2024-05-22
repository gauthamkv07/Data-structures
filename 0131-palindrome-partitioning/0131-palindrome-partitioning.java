class Solution {
    List<List<String>> list;
    List<String> curr;
    int n;

    public List<List<String>> partition(String s) {
        list = new ArrayList<>();
        curr = new ArrayList<>();
        n = s.length();
        bc(s, 0);
        return list;
    }

    public void bc(String s, int start) {
        if(start == n) {
            list.add(new ArrayList<>(curr));
            return;
        }
        for(int i = start; i < n; i++) {
            if(!isPalindrome(s, start, i)) continue;
            curr.add(s.substring(start, i+1));
            bc(s, i+1);
            curr.remove(curr.size() - 1);
        }
    }

    public boolean isPalindrome(String s, int l, int r) {
        while(l <= r) if(s.charAt(l++) != s.charAt(r--)) return false;
        return true;
    }
}