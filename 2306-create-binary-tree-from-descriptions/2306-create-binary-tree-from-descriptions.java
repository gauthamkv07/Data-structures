/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int[] desc : descriptions) {
            TreeNode root, child;
            if (map.containsKey(desc[0]))
                root = map.get(desc[0]);
            else {
                root = new TreeNode(desc[0]);
                map.put(desc[0], root);
            }
            if (map.containsKey(desc[1]))
                child = map.get(desc[1]);
            else {
                child = new TreeNode(desc[1]);
                map.put(desc[1], child);
            }
            if (desc[2] == 1)
                root.left = child;
            else
                root.right = child;
            if (countMap.getOrDefault(desc[0], 0) > -1)
                countMap.put(desc[0], countMap.getOrDefault(desc[0], 0) + 1);
            countMap.put(desc[1], -1);
        }

        TreeNode root = null;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value > 0) {
                root = map.get(key);
                break;
            }
        }

        return root;
    }
}