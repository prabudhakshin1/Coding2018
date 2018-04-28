/**
 * https://leetcode.com/problems/house-robber-iii/description/
 * 
 * The thief has found himself a new place for his thievery again. There is only one entrance
 * to this area, called the "root." Besides the root, each house has one and only one parent house.
 * After a tour, the smart thief realized that "all houses in this place forms a binary tree".
 * It will automatically contact the police if two directly-linked houses were broken into on the same night.

 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class HouseRobber3 {
    public int rob(TreeNode root) {
        int[] withAndWithout = helper(root);
        return Math.max(withAndWithout[0], withAndWithout[1]);
    }
    
    private int[] helper(TreeNode root) {
        int[] withAndWithout = new int[2];
        
        if (root == null)
            return withAndWithout;
        
        if (root.left == null && root.right == null) {
            withAndWithout[0] = root.val;
            return withAndWithout;
        }
        
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        
        withAndWithout[0] = root.val + left[1] + right[1];
        withAndWithout[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        
        return withAndWithout;
    }
}