class Solution {
    class Union {

        int n, max;
        int[] parent;
        int[] size;

        public Union(int n) {
            this.n = n;
            parent = new int[n+1];
            size = new int[n+1];
            max = 1;
            for(int i = 0 ; i < n; i++) parent[i] = i;
            Arrays.fill(size, 1);
        }

        public int find(int x) {
            if(parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        public boolean union(int x, int y) {
            x = find(x);
            y = find(y);

            if(x == y) return true;

            if(size[x] < y) {
                parent[x] = y;
                size[y] += size[x];
                max = Math.max(size[y], max);
            } else {
                parent[y] = x;
                size[x] += size[y];
                max = Math.max(size[x], max);
            }

            return false;
        }
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Union df = new Union(n), df2 = new Union(n);
        int res = 0;

        for(int[] edge: edges) if(edge[0] == 3 && (df.union(edge[1], edge[2])|| df2.union(edge[1], edge[2])))  res++;

        for(int[] edge: edges) {
            if(edge[0] == 1 && df.union(edge[1], edge[2])) res++;
            if(edge[0] == 2 && df2.union(edge[1], edge[2])) res++; 
        }

        return df.max == n && df2.max == n? res: -1;
    }
}