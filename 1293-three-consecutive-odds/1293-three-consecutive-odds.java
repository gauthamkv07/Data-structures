class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        for(int i = 0, c = 0; i < arr.length; i++) {
            if(arr[i] % 2 == 1){
                c++;
                if(c == 3) return true;
                continue;
            }
            c = 0;
        }
        return false;
    }
}