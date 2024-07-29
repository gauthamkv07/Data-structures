class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int res = 0;

        for(int mid = 1; mid < n-1; mid++) {
            int ls = 0, rg = 0;

            for(int i = mid-1; i >= 0; i--) if(rating[i] < rating[mid]) ls++;
            for(int i = mid+1; i < n; i++) if(rating[i] > rating[mid]) rg++;

            res += ls * rg;

            int lg = 0, rs = 0;
            for(int i = mid-1; i >= 0; i--) if(rating[i] > rating[mid]) lg++;
            for(int i = mid+1; i < n; i++) if(rating[i] < rating[mid]) rs++;

            res += lg * rs;
        }

        return res;
    }
}