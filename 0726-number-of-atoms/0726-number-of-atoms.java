class Solution {
    public String countOfAtoms(String formula) {
        HashMap<String,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder(), stb = new StringBuilder();
        int n = formula.length();

        Deque<String> stack = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            char c = formula.charAt(i);
            StringBuilder temp = new StringBuilder();
            if(c >= 'A' && c <= 'Z') {
                temp.append(c);
                while(i + 1 < n && formula.charAt(i+1) >= 'a' && formula.charAt(i+1) <= 'z') {
                    i++;
                    temp.append(formula.charAt(i));
                }
                int val = 0;
                while(i + 1 < n && formula.charAt(i+1) >= '0' && formula.charAt(i+1) <= '9') {
                    i++;
                    int curr = formula.charAt(i) - '0';
                    val = (val * 10) + curr;
                }
                if(val == 0) val = 1;
                temp.append(String.valueOf(val));
                stack.addLast(temp.toString());
                // System.out.println(stack.peek());
                continue;
            }
            if(c == ')') {
                Stack<String> revStack = new Stack<>();
                int val = 0;
                while(i + 1 < n && formula.charAt(i+1) >= '0' && formula.charAt(i+1) <= '9') {
                    i++;
                    int curr = formula.charAt(i) - '0';
                    val = (val * 10) + curr;
                }
                if(val == 0) val = 1;
                while(!stack.isEmpty()) {
                    String value = stack.removeLast();
                    if(value.equals("(")) break;
                    StringBuilder newsb = new StringBuilder();
                    int j = 0;
                    while(j < value.length() && value.charAt(j) >= 'A' && value.charAt(j) <= 'z') {
                        newsb.append(value.charAt(j++));
                    }
                    int cVal = 0;
                    while(j < value.length() && value.charAt(j) >= '0' && value.charAt(j) <= '9') {
                        int curr = value.charAt(j++) - '0';
                        cVal = (cVal * 10) + curr;
                    }
                    if(cVal == 0) cVal = 1;
                    cVal *= val;
                    newsb.append(String.valueOf(cVal));
                    revStack.add(newsb.toString());
                    // System.out.println(revStack.peek());
                }
                while(!revStack.isEmpty()) stack.addLast(revStack.pop());
                continue;
            }
            stack.add(String.valueOf(c));
        }
        while(!stack.isEmpty()) stb.append(stack.removeFirst());
        formula = stb.toString();
        n = formula.length();

        for(int i = 0; i < n; i++) {
            char c = formula.charAt(i);
            StringBuilder temp = new StringBuilder();
            if(c >= 'A' && c <= 'Z') {
                temp.append(c);
                while(i + 1 < n && formula.charAt(i+1) >= 'a' && formula.charAt(i+1) <= 'z') {
                    i++;
                    temp.append(formula.charAt(i));
                }
                int val = 0;
                while(i + 1 < n && formula.charAt(i+1) >= '0' && formula.charAt(i+1) <= '9') {
                    i++;
                    int curr = formula.charAt(i) - '0';
                    val = (val * 10) + curr;
                }
                if(val == 0) val = 1;
                String cS = temp.toString();
                map.put(cS, map.getOrDefault(cS, 0) + val);
            }
        }

        Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                return entry1.getKey().compareTo(entry2.getKey());
            }
        };

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(comparator);

        pq.addAll(map.entrySet());

        // Process the priority queue
        while (!pq.isEmpty()) {
            Map.Entry<String, Integer> entry = pq.poll();
            int val = entry.getValue();
            sb.append(entry.getKey());
            if(val>1) sb.append(String.valueOf(val));
            // System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        return sb.toString(); 
    }
}