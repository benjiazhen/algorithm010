双端BFS代码模板

```
public  void TowEndedBfs(Node startNode,Node endNode,List<Node> allNodes)
	{
		//层序遍历结果
		List<List<Node>> res = new ArrayList();
		Set<Node> visited = new HasSet();
		Queue<Node> start=new LinkedList();
		Queue<Node> end = new LinkedList();
		start.add(startNode);
		end.add(endNode);
		while (!start.isEmpty() && !end.isEmpty())
		{
			if(start.size()>end.size())
			{
				Queue tmp = start;
				start = end;
				end =temp;
			}
			Queue<Node> temp = new LinkedList();
			for(Node node : start)
			{
				if(node in visited)
				{
				continue;
				}
				process(node);
				if(node in end)
				{
					return;
				}
				if(node in allNodes)
				{
					visited.add(node);
					temp.add(node);
				}
				reverse node;
			}
			begin = temp;
			res.add(temp);
		}
	}
```



树的时间复杂度只和高度有关，所以才会演化出AVL树，才会有平衡因子，也就是高度差

![image-20200721215652100](C:\Users\Administrator.SKY-20160814UDH\AppData\Roaming\Typora\typora-user-images\image-20200721215652100.png)

![image-20200725113519902](C:\Users\Administrator.SKY-20160814UDH\AppData\Roaming\Typora\typora-user-images\image-20200725113519902.png)



字典树（Trie树）

![image-20200725115924197](C:\Users\Administrator.SKY-20160814UDH\AppData\Roaming\Typora\typora-user-images\image-20200725115924197.png)

字典树模板代码

```java
//Java
class Trie {
    private boolean isEnd;
    private Trie[] next;
    /** Initialize your data structure here. */
    public Trie() {
        isEnd = false;
        next = new Trie[26];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0) return;
        Trie curr = this;
        char[] words = word.toCharArray();
        for (int i = 0;i < words.length;i++) {
            int n = words[i] - 'a';
            if (curr.next[n] == null) curr.next[n] = new Trie();
            curr = curr.next[n];
        }
        curr.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = searchPrefix(prefix);
        return node != null;
    }

    private Trie searchPrefix(String word) {
        Trie node = this;
        char[] words = word.toCharArray();
        for (int i = 0;i < words.length;i++) {
            node = node.next[words[i] - 'a'];
            if (node == null) return null;
        }
        return node;
    }
}
```

并查集代码模板

```java
class UnionFind { 
	private int count = 0; 
	private int[] parent; 
	public UnionFind(int n) { 
		count = n; 
		parent = new int[n]; 
		for (int i = 0; i < n; i++) { 
			parent[i] = i;
		}
	} 
	public int find(int p) { 
		while (p != parent[p]) { 
			parent[p] = parent[parent[p]]; 
			p = parent[p]; 
		}
		return p; 
	}
	public void union(int p, int q) { 
		int rootP = find(p); 
		int rootQ = find(q); 
		if (rootP == rootQ) return; 
		parent[rootP] = rootQ; 
		count--;
	}
}
```

