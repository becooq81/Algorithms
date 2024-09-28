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
    static int minDepth = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        minDepth = Integer.MAX_VALUE;
        if (root == null) return 0;
        recurse(root, 1);
        return minDepth;
    }

    private void recurse(TreeNode node, int depth) {
        if (node.left == null && node.right == null) {
            minDepth = Math.min(depth, minDepth);
            return;
        }

        if (node.left != null) {

            recurse(node.left, depth +1);
        }
        if (node.right != null) {
            recurse(node.right, depth +1);
        }
    }
}