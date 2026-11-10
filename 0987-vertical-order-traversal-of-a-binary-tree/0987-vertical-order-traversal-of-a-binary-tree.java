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
    class NodeInfo{
        int row,col,val;
        NodeInfo(int r, int c, int v){
            row = r;
            col = c;
            val = v;
        }
    }
    List<NodeInfo> nodes = new ArrayList<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root,0,0);
        Collections.sort(nodes,(a,b)->{
            if(a.col!=b.col)return a.col - b.col;
            if(a.row!=b.row)return a.row - b.row;
            return a.val-b.val;
        });
        List<List<Integer>> ans = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;
        for(NodeInfo node: nodes){
            if(node.col!=prevCol){
                ans.add(new ArrayList<>());
                prevCol = node.col;
            }
            ans.get(ans.size()-1).add(node.val);
        }
        return ans;
    }
    private void dfs(TreeNode root, int row, int col){
        if(root == null)return ;
        nodes.add(new NodeInfo(row,col,root.val));
        dfs(root.left,row+1,col-1);
        dfs(root.right,row+1,col+1);
    }
}