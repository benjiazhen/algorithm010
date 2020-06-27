/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*
        时间复杂度O(n);
        空间复杂度O(n)
        */
        //终止条件
        if(root == null || root == p || root ==q)
        {
            return root;
        }
        //当前层的逻辑
        //下一层
        TreeNode inleft = lowestCommonAncestor(root.left,p,q);
        TreeNode inright = lowestCommonAncestor(root.right,p,q);
        if(inleft != null && inright != null)
        {
            return root;
        } 
        return inleft == null?inright:inleft;
    }
}