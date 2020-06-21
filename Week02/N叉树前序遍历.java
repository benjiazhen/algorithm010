/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList();
        method(root,result);
        return result;
    }

    /**
    1.
    时间复杂度:O(n)
    空间复杂度:O(n)
    */
    public void method(Node root,List<Integer> result)
    {
        if(root == null)
        {
            return;
        }
        result.add(root.val);
        for(Node node:root.children)
        {
            method(node,result);
        }
    }


}