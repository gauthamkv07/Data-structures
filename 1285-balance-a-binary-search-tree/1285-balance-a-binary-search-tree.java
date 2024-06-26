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
    List<Integer> list = new ArrayList<>();

    public void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    public TreeNode creatBalanceBst(int l, int r) {
        if(l > r) return null;

        int mid = l + (r-l)/2;

        TreeNode left = creatBalanceBst(l, mid - 1);
        TreeNode right = creatBalanceBst(mid + 1, r);

        return new TreeNode(list.get(mid), left, right);
    }

    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return creatBalanceBst(0, list.size() - 1);
    }
}