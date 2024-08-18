class Solution {
    public int min(int n1, int n2, int n3) {
        return n1 > n2?(n2 > n3? n3: n2): (n1 > n3? n3: n1);
    }

    public int nthUglyNumber(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        int[] k = new int[n];
        k[0] = 1;
        int i = 0, t2 = 0, t3 = 0, t5 = 0;
        while(++i < n) {
            k[i] = min(k[t2] * 2, k[t3] * 3, k[t5] * 5);
            if(k[t2] * 2 == k[i]) t2++;
            if(k[t3] * 3 == k[i]) t3++;
            if(k[t5] * 5 == k[i]) t5++;
        }
        return k[n-1];
    }
}