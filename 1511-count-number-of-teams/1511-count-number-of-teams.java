class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int res = 0;

        int[][] dec = new int[n][4], inc = new int[n][4];

        for(int i = 0; i < n; i++) {
            inc[i][1] = 1;
            dec[i][1] = 1;
        }

        for(int count = 2; count < 4; count++) {
            for(int i = 0; i < n; i++) {
                for(int j = i+1; j < n; j++) {
                    if(rating[j] > rating[i]) inc[j][count] += inc[i][count-1];
                    if(rating[j] < rating[i]) dec[j][count] += dec[i][count-1];
                }
            }
        }

        for(int i = 2; i < n; i++) res += inc[i][3] + dec[i][3]; 

        return res;  
    }
}