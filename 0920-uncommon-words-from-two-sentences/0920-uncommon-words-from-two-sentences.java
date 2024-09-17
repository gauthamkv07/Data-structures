class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> map = new HashMap<>();

        String[] arr = s1.split(" ");

        for(String s: arr) map.put(s, map.getOrDefault(s, 0) + 1);

        arr = s2.split(" ");

        for(String s: arr) map.put(s, map.getOrDefault(s, 0) + 1);

        List<String> list = new ArrayList<>();

        for(String s: map.keySet()) if(map.get(s) == 1) list.add(s);

        String[] res = new String[list.size()];

        for(int i = 0; i < list.size(); i++) res[i] = list.get(i);

        return res;
    }
}