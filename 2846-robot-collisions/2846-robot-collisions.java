class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        List<Integer> list = new ArrayList<>();

        int[][] arr = new int[n][4];

        for(int i = 0; i < n; i++) {
            arr[i][0] = positions[i];
            arr[i][1] = healths[i];
            arr[i][2] = directions.charAt(i) == 'L'? 0 : 1;
            arr[i][3] = i;
        }

        Arrays.sort(arr, (a,b) -> Integer.compare(a[0], b[0]));

        // for(int[] a: arr) System.out.println(a[0] + " " + a[1] + " " + a[2] + " " + a[3]);

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            if(arr[i][2] == 1) {
                stack.push(i);
                continue;
            }
            while(!stack.isEmpty() && arr[i][1] > 0) {
                int val = stack.pop();
                if(arr[val][1] > arr[i][1]) {
                    arr[i][1] = 0;
                    arr[val][1]--;
                    stack.push(val);
                } else if(arr[i][1] > arr[val][1]) {
                    arr[val][1] = 0;
                    arr[i][1]--;
                } else {
                    arr[i][1] = 0;
                    arr[val][1] = 0;
                }
            }          
        }

        Arrays.sort(arr, (a,b) -> Integer.compare(a[3], b[3]));

        for(int[] a: arr) if(a[1] > 0) list.add(a[1]);

        return list;
    }
}