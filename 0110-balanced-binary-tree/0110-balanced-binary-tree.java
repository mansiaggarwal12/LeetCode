/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
https://assets.leetcode.com/uploads/2020/10/06/balance_1.jpg$0 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return check(root)!=-1;
    }
    public int check(TreeNode root){
        if(root==null)return 0;
        int left = check(root.left);
        if(left == -1) return -1;
        int right = check(root.right);
        if(right==-1)return -1;
        if(Math.abs(left-right)>1)return -1;
        return 1+Math.max(left,right);
    }
}