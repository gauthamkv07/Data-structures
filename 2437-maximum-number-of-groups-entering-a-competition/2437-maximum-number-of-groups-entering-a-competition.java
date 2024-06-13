class Solution {
    public int maximumGroups(int[] grades) {
        Arrays.sort(grades);
        int psum = grades[0],sum = 0, pgs = 1,cgs = 0, res = 1;
        for(int i = 1; i < grades.length; i++) {
            sum += grades[i];
            cgs++;
            if(cgs > pgs && sum > psum) {
                res++;
                psum = sum;
                sum = 0;
                pgs = cgs;
                cgs = 0;
            }
        }
        return res;
    }
}