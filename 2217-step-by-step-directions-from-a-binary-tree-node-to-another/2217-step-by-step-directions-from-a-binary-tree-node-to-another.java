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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = findLCA(root, startValue, destValue);

        StringBuilder pathToStart = new StringBuilder();
        StringBuilder pathToDest = new StringBuilder();

        generatePath(lca, startValue, pathToStart);
        generatePath(lca, destValue, pathToDest);

        StringBuilder res = new StringBuilder();

        res.append("U".repeat(pathToStart.length()));

        res.append(pathToDest.toString());

        return res.toString();
    }

    public TreeNode findLCA(TreeNode root, int startValue, int destValue) {
        if(root == null) return null;

        if(root.val == startValue || root.val == destValue) return root;

        TreeNode left = findLCA(root.left, startValue, destValue);
        TreeNode right = findLCA(root.right, startValue, destValue);

        if(left == null) return right;
        else if(right == null) return left;
        return root;
    }

    public boolean generatePath(TreeNode root, int value, StringBuilder path) {
        if(root == null) return false;

        if(root.val == value) return true;

        path.append("L");
        if(generatePath(root.left, value, path)) return true;
        path.setLength(path.length() - 1);

        path.append("R");
        if(generatePath(root.right, value, path)) return true;
        path.setLength(path.length() - 1);

        return false;
    }
}