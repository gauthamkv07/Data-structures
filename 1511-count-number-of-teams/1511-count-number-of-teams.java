class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int res = 0, maxRating = 0;

        for(int r: rating) maxRating = Math.max(r, maxRating);

        int[] leftBIT = new int[maxRating+1], rightBIT = new int[maxRating+1];

        for(int r: rating) update(rightBIT, r, 1);

        for(int r: rating) {
            update(rightBIT, r, -1);

            int leftSmaller = get(leftBIT, r-1);
            int rightSmaller = get(rightBIT, r-1);

            int leftLarger = get(leftBIT, maxRating) - get(leftBIT, r);
            int rightLarger = get(rightBIT, maxRating) - get(rightBIT, r);

            res += leftSmaller * rightLarger;
            res += leftLarger * rightSmaller;

            update(leftBIT, r, 1);
        }

        return res;
    }

    private void update(int[] bit, int index, int value) {
        while(index < bit.length) {
            bit[index] += value;
            index += index & (-index);
        }
    }

    private int get(int[] bit, int index) {
        int sum = 0;
        while(index > 0) {
            sum += bit[index];
            index -= index & (-index);
        }
        return sum;
    }
}