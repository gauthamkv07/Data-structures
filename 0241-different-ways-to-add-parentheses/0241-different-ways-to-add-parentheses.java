class Solution {
    List<Integer>[][] memo;
    int n;

    public List<Integer> diffWaysToCompute(String expression) {
        n = expression.length();

        memo = new ArrayList[n][n];

        return computeResults(expression, 0, n - 1);
    }

    public List<Integer> computeResults(String expression,int start, int end) {
        if(memo[start][end] != null) return memo[start][end];

        List<Integer> res = new ArrayList<>();

        if(start == end) {
            res.add(expression.charAt(start) - '0');
            return res;
        }

        if(end - start == 1 && Character.isDigit(expression.charAt(start))) {
            int tens = expression.charAt(start) - '0';
            int ones = expression.charAt(end) - '0';

            res.add(10*tens+ones);
            return res;
        }

        for(int i = start; i <= end; i++) {
            char c = expression.charAt(i);
            
            if(Character.isDigit(c)) continue;

            List<Integer> leftRes = computeResults(expression, start, i-1);
            List<Integer> rightRes = computeResults(expression, i+1, end);

            for(int left: leftRes) {
                for(int right: rightRes) {
                    switch(c){
                        case '+':
                            res.add(left + right);
                            break;
                        case '*':
                            res.add(left * right);
                            break;
                        case '-':
                            res.add(left - right);
                            break;
                    }
                }
            }
        }

        memo[start][end] = res;

        return res;
    }
}