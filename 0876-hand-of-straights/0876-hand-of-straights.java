class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0) return false;

        Map<Integer,Integer> map = new TreeMap<>();

        for(int h: hand) map.put(h, map.getOrDefault(h, 0) + 1);

        while(map.size() > 0) {
            int curr = map.entrySet().iterator().next().getKey();

            for(int i = 0; i < groupSize; i++) {
                int key = curr + i;
                if(!map.containsKey(key)) return false;

                map.put(key, map.get(key) - 1);
                if(map.get(key) == 0) map.remove(key);
            }
        }

        return true;
    }
}