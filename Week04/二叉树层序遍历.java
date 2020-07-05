class Solution {
   public List<List<Integer>> levelOrder(TreeNode root) {
        return method1(root);
    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     */
    public List<List<Integer>> method1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
        {
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        Set<TreeNode> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for(int i = 0;i< size;i++)
            {
                TreeNode first = queue.remove();
                if (!visited.contains(first)) {
                    visited.add(first);
                    level.add(first.val);
                }
                if (first.left != null && !visited.contains(first.left)) {
                    queue.add(first.left);
                }
                if (first.right != null && !visited.contains(first.right)) {
                    queue.add(first.right);
                }
            }
            if (!level.isEmpty()) {
                result.add(level);
            }
        }
        return result;
    }
}