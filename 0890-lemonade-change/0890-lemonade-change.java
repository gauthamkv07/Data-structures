class Solution {
    public boolean lemonadeChange(int[] bills) {
        int billsInHand = 0, billFive = 0, billTen = 0;
        for(int bill: bills) {
            if(bill == 5) billFive++;
            else if(bill == 10) {
                billTen++;
                if(billFive == 0) return false;
                billFive--;
            } else if(billTen > 0 && billFive > 0) {
                billTen--;
                billFive--;
            } else if(billFive > 2) {
                billFive -= 3;
            } else return false;
        }
        return true;
    }
}