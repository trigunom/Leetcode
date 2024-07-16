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
    private StringBuilder pathToStart;
    private StringBuilder pathToDest;
    private boolean foundStart;
    private boolean foundDest;

    public String getDirections(TreeNode root, int startValue, int destValue) {
        pathToStart = new StringBuilder();
        pathToDest = new StringBuilder();
        foundStart = false;
        foundDest = false;

        TreeNode lca = findLCA(root, startValue, destValue);
        
        findPath(lca, startValue, new StringBuilder(), true);
        
        findPath(lca, destValue, new StringBuilder(), false);
        
        return "U".repeat(pathToStart.length()) + pathToDest.toString();
    }

    private TreeNode findLCA(TreeNode node, int p, int q) {
        if (node == null || node.val == p || node.val == q) {
            return node;
        }
        
        TreeNode left = findLCA(node.left, p, q);
        TreeNode right = findLCA(node.right, p, q);
        
        if (left != null && right != null) {
            return node;
        }
        
        return (left != null) ? left : right;
    }

    private void findPath(TreeNode node, int target, StringBuilder currentPath, boolean isStart) {
        if (node == null) {
            return;
        }
        
        if (node.val == target) {
            if (isStart) {
                pathToStart = currentPath;
                foundStart = true;
            } else {
                pathToDest = currentPath;
                foundDest = true;
            }
            return;
        }
        
        if (!foundStart && isStart) {
            findPath(node.left, target, currentPath.append("L"), isStart);
            if (!foundStart) {
                currentPath.setLength(currentPath.length() - 1);
                findPath(node.right, target, currentPath.append("R"), isStart);
                if (!foundStart) {
                    currentPath.setLength(currentPath.length() - 1);
                }
            }
        }
        
        if (!foundDest && !isStart) {
            findPath(node.left, target, currentPath.append("L"), isStart);
            if (!foundDest) {
                currentPath.setLength(currentPath.length() - 1);
                findPath(node.right, target, currentPath.append("R"), isStart);
                if (!foundDest) {
                    currentPath.setLength(currentPath.length() - 1);
                }
            }
        }
    }
}