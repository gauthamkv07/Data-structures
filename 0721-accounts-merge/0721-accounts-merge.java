class Solution {
    class DSU {
        int[] parent;
        int[] size;

        public DSU(int n) {
            parent = new int[n];
            size = new int[n];

            for(int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if(parent[x] == x) return x;
            return parent[x] = find(parent[x]);
        }

        public void union(int x, int y) {
            x = find(x);
            y = find(y);

            if(x == y) return;

            if(size[x] >= y) {
                parent[y] = x;
                size[x] += size[y];
            } else {
                parent[x] = y;
                size[y] += size[x];
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DSU dsu = new DSU(n);

        Map<String, Integer> emailGroup = new HashMap<>();

        for(int i = 0; i < n; i++) {
            int size = accounts.get(i).size();
            String accName = accounts.get(i).get(0);

            for(int j = 1; j < size; j++) {
                String email = accounts.get(i).get(j);

                if(!emailGroup.containsKey(email)) emailGroup.put(email, i);
                else dsu.union(i, emailGroup.get(email));
            }
        }

        Map<Integer, List<String>> components = new HashMap<>();

        for(String email: emailGroup.keySet()) {
            int group = emailGroup.get(email);
            int groupRep = dsu.find(group);

            if(!components.containsKey(groupRep)) components.put(groupRep, new ArrayList<>());

            components.get(groupRep).add(email);
        }

        List<List<String>> mergedAccounts = new ArrayList<>();

        for(int group: components.keySet()) {
            List<String> list = components.get(group);

            Collections.sort(list);
            list.add(0, accounts.get(group).get(0));
            mergedAccounts.add(list);
        }

        return mergedAccounts;
    }
}