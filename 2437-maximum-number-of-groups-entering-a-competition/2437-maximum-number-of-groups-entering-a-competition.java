class Solution {
    public int maximumGroups(int[] grades) {
        int sum = 0, k = 0, n = grades.length;
        while(sum + k + 1 <= n) sum += ++k;
        return k;
    }
}