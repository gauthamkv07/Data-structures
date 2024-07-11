class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int[] pair = new int[n];

        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c == '(') stack.push(i);
            else if(c == ')') {
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }

        for(int i = 0, d = 1; i < n; i+=d) {
            char c = s.charAt(i);
            if(c == '(' || c == ')') {
                d = -d;
                i = pair[i];
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}