class Solution {
    public int passThePillow(int n, int time) {
        int pos = time % (n-1);
        int dir = (time / (n-1)) % 2;
        return dir == 1? n - pos: pos + 1;
    }
}