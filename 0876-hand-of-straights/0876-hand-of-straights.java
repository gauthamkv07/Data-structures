class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0) return false;

        Map<Integer,Integer> map = new HashMap<>();
        for(int h: hand) map.put(h, map.getOrDefault(h,0) + 1);

        for(int card: hand) {
            int curr = card;
            while(map.getOrDefault(curr - 1, 0) > 0) curr--;

            while(curr <= card && map.getOrDefault(curr, 0) > 0) {
                for(int i = curr; i < curr + groupSize; i++) {
                    if(map.getOrDefault(i,0) == 0) return false;
                    map.put(i, map.getOrDefault(i,0) - 1);
                    if(map.get(i) == 0) map.remove(i);
                }
                if(!map.containsKey(curr)) curr++;
            } 
        }
        
        return true;
    }
}