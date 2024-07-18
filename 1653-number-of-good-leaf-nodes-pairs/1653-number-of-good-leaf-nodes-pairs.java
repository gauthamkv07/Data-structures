/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countPairs(TreeNode root, int distance) {
        return postOrderTraversal(root, distance)[11];
    }

    public int[] postOrderTraversal(TreeNode root, int distance){
        if(root == null) return new int[12];

        if(root.left == null && root.right == null) {
            int[] arr = new int[12];
            arr[0] = 1;
            return arr;
        }

        int[] left = postOrderTraversal(root.left, distance);
        int[] right = postOrderTraversal(root.right, distance);

        int[] arr = new int[12];
        for(int i = 0; i < 10; i++) arr[i+1] = left[i] + right[i];

        arr[11] = left[11] + right[11];

        for(int i = 0; i <= distance; i++) {
            for(int j = 0; j <= distance; j++){
                if(2 + i + j > distance) continue;
                arr[11] += left[i] * right[j];
            }
        }

        return arr;
    }
}