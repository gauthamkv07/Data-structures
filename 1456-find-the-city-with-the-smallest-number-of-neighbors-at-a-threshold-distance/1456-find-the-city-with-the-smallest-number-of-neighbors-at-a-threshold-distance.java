class Solution {

    //Floyd warshall (it wont work on neg edges)
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];

        //initializing all distance to max
        for(int i = 0; i < n; i++) Arrays.fill(dist[i], 1000000);

        //Distance to self node is zero
        for(int i = 0; i < n; i++) dist[i][i] = 0;

        //Initailizing all the given vertix distance.
        for(int[] edge: edges) {
            int src = edge[0];
            int des = edge[1];
            dist[src][des] = edge[2];
            dist[des][src] = edge[2];
        }

        //Floyd marshall finding shortest distance of all paths by calculating paths n times.
        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        //Variable to store and calculate result
        int city = -1, nofcities = n;

        for(int i = 0; i < n; i++) {
            //variable to store no of cities less than threshold for given node
            int count = 0;
            for(int j = 0; j < n; j++) {
                if(i != j && dist[i][j] <= distanceThreshold) count++;
            }
            if(count <= nofcities) {
                nofcities = count;
                city = i;
            }
        }

        return city;
    }
}