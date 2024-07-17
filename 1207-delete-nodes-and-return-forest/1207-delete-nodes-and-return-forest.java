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
    List<TreeNode> list;
    HashSet<Integer> set;
    
    public TreeNode dfs(TreeNode root, boolean add) {
        if(root == null) return null;

        boolean isDeleted = set.contains(root.val);
        if(add && !isDeleted) list.add(root);
        root.left = dfs(root.left, isDeleted);
        root.right = dfs(root.right, isDeleted);
        return isDeleted? null : root;
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        set = new HashSet<>();
        for(int d: to_delete) set.add(d);

        list = new ArrayList<>();

        dfs(root, true);

        return list;
    }
}