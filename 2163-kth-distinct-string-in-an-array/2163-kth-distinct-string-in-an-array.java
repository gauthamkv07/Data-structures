class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String,Integer> map = new HashMap<>();

        for(String a: arr) map.put(a, map.getOrDefault(a, 0) + 1);

        for(String a: arr) {
            if(map.get(a) == 1) k--;
            if(k == 0) return a;
        }
        
        return "";
    }
}