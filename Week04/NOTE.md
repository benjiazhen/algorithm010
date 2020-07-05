学习笔记

### 深度优先模板

递归

```python
visited = set() 
def dfs(node, visited):
    if node in visited: # terminator
    	# already visited 
    	return 
	visited.add(node) 
	# process current node here. 
	...
	for next_node in node.children(): 
		if next_node not in visited: 
			dfs(next_node, visited)
```

```java
public  void dfs(Node node)
	{
   		  if(!node.visited)
		{
				System.out.print(node.data + " ");
				node.visited=true;
		}
        List neighbours=node.getNeighbours();
        for(Node node : node.getNeighbours())
        {
        	if(n!=null && !n.visited)
			{
				dfs(n);
			}
        }
	}
```

非递归

```python
def DFS(self, tree): 
	if tree.root is None: 
		return [] 
	visited, stack = [], [tree.root]
	while stack: 
		node = stack.pop() 
		visited.add(node)
		process (node) 
		nodes = generate_related_nodes(node) 
		stack.push(nodes) 
	# other processing work 
	...
```

```java
// Iterative DFS using stack
	public  void dfsUsingStack(Node node)
	{
		Stack<Node> stack=new  Stack<Node>();
		stack.push(node);
		while (!stack.isEmpty())
		{
			Node node=stack.pop();
			if(!node.visited)
			{
				System.out.print(element.data + " ");
				node.visited=true;
			}
			
			 for(Node node : node.getNeighbours())
        {
        	if(n!=null && !n.visited)
			{
				stack.push(node);
			}
        }
		}
	}
```



### 广度优先模板

```python
def BFS(graph, start, end):
    visited = set()
	queue = [] 
	queue.add([start]) 
	while queue: 
		node = queue.pop() 
		visited.add(node)
		process(node) 
		nodes = generate_related_nodes(node) 
		queue.add(nodes)
	# other processing work 
	...
```



### 贪心算法

贪心：当下作局部最优

回溯：能够回退

动态规划：最优判断+回退（保存中间结果）

### 二分查找

1.目标函数单调性（单调递增或者递减）

2.存在上下界

3.能够通过索引访问

模板：

```python
left, right = 0, len(array) - 1 
while left <= right: 
	  mid = (left + right) / 2 
	  if array[mid] == target: 
		    # find the target!! 
		    break or return result 
	  elif array[mid] < target: 
		    left = mid + 1 
	  else: 
		    right = mid - 1
```

使用线性查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方

```
 		int j = 0;
        for( int i =0 ;i< a.length -2;i++)
        {
            if(a[i] <= a[i+1])
            {
                j++;
            }else
            {
                break;
            }
        }
        return j+1;
```

使用二分查找

```
        int left = 0 ;
        int right = a.length - 1;
        int mid = 0;
        while(left < right)
        {
            mid = left +(right - left)/2;
             if(a[mid] > a[right])
            {
                left = mid+1;
            }else
             {
                 right = mid;
             }
        }
        return left;
```

