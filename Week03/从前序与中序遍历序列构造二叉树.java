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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        /*
        时间复杂度O(n2)
        空间复杂度O(n2)
        */
        //终止条件

        int n = preorder.length;
        if(n == 0)
        {
            return null;
        }
        if(n == 1)
        {
            return new TreeNode(preorder[0]);
        }

        //当前层逻辑
        int l = 0;
        for(int i = 0;i<n;i++)
        {
            if(inorder[i] == preorder[0])
            {
                l = i;
            }
        }
        TreeNode root = new TreeNode(preorder[0]);
        //下一层
        root.left =  buildTree(Arrays.copyOfRange(preorder,1,l+1),Arrays.copyOfRange(inorder,0,l));
        root.right = buildTree(Arrays.copyOfRange(preorder,1+l,n),Arrays.copyOfRange(inorder,l+1,n));
        return root;
    }
}