class Solution {
    public boolean canAliceWin(int n) {
        int curr = 10;
        boolean isAliceTurn = true;

        while(n > 0) {
            if(n >= curr) {
                isAliceTurn = !isAliceTurn;
                n -= curr;
                curr--;
            } else{
                break;
            }
        }

        return !isAliceTurn;
    }
}