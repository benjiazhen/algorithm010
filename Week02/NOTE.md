

**HasMap源码分析：**

基于散列表的KEY-VALUE数据结构，Map是Map接口的实现类，key,value允许为null。

影响性能的两个参数：

- init capacity：散列表初始化的大小
- load factory：用来衡量是否需要扩容散列表

| 方法名 | 时间复杂度 |
| ------ | ---------- |
| get(e) | O(1)       |
| put(e) | O(1)       |

```
/**
     * Implements Map.get and related methods
     *
     * @param hash hash for key
     * @param key the key
     * @return the node, or null if none
     */
    final Node<K,V> getNode(int hash, Object key) {
        Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
        if ((tab = table) != null && (n = tab.length) > 0 &&
            (first = tab[(n - 1) & hash]) != null) {
            if (first.hash == hash && // always check first node
                ((k = first.key) == key || (key != null && key.equals(k))))
                return first;
            if ((e = first.next) != null) {
               //红黑树
                if (first instanceof TreeNode)
                    return ((TreeNode<K,V>)first).getTreeNode(hash, key);
               //链表
               do {
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        return e;
                } while ((e = e.next) != null);
            }
        }
        return null;
    }
```

```
  static final int hash(Object key) {
        int h;
        //低16位和高16位进行异或运算
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
```

```
 /**
     * Implements Map.put and related methods
     *
     * @param hash hash for key
     * @param key the key
     * @param value the value to put
     * @param onlyIfAbsent if true, don't change existing value
     * @param evict if false, the table is in creation mode.
     * @return previous value, or null if none
     */
    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
            //如果目标位置的节点为空，则将此节点添加到目标位置
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        else {
            Node<K,V> e; K k;
            ////如果目标位置的节点和此节点相等
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
                //如果目标位置的节点是红黑树节点
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        //如果链表节点大于等于5，则红黑树化
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }
```

## 树

### 概念

父节点 子节点 兄弟节点 根节点 叶子节点

高度(height) 深度(depth) 层(level)

节点的高度 = 该节点到叶子节点的最长路径(边数)
节点的深度 = 根节点到该节点所经历的边的个数
节点的层数 = 节点的深度 + 1
树的高度 = 根节点的高度

### 二叉树

1. 叶子节点全都在最底层
2. 除了叶子节点外，每个节点都有左右两个子节点

#### 完全二叉树

1. 除了最后一层外，其他层的节点个数都是满的
2. 最后一层的叶子节点都靠左排列

#### 二叉树的存储

> 如果一棵树是完全二叉树，那么用数组存储无疑是最节省内存的方式。
> 因为数组的存储方式并不需要存储额外的指针。
> 上面的存储方式会浪费一个内存空间，我们也可以把根节点存储在 `i=0` 的位置，那么他的左子节点就存储在 `2*i+1` 位置， 他的右子节点存储在 `2*i+2` 位置，数组下标为 `i` 的父节点的下标为 `Math.floor((i-1)/2)`

#### 二叉树的遍历

前序遍历、中序遍历、后序遍历

```
前序遍历的递推公式：
preOrder(root) = print root -> preOrder(root.left) -> preOrder(root.right)
根 -> 左 -> 右

中序遍历的递推公式：
inOrder(root) = inOrder(root.left) -> print root -> inOrder(root.right)
左 -> 根 -> 右

后序遍历的递推公式：
postOrder(root) = postOrder(root.left) -> postOrder(root.right) -> print root
左 -> 右 -> 根
```

### 二叉搜索树(Binary Search Tree, BST)

#### 特点

- 左子树上所有节点的值均小于它的根节点的值
- 右子树上所有节点的值均大于它的根节点的值
- 以此类推，左右子树也分别为二叉搜索树

> 也就是说，这棵树是有序的，类似于跳表

> 对二叉搜索树的中序遍历，是一个升序遍历
>
> 因为中序遍历的顺序为：左 -> 根 -> 右



二叉搜索树的插入（递归）：

```
public void add(int value) {
    root = addRecursive(root, value);
}
private Node addRecursive(Node current, int value) {
    if (current == null) {
        return new Node(value);
    }
 
    if (value < current.value) {
        current.left = addRecursive(current.left, value);
    } else if (value > current.value) {
        current.right = addRecursive(current.right, value);
    } else {
        // value already exists
        return current;
    }
 
    return current;
}
```

二叉搜索树的查找（递归）：

```
private boolean containsNodeRecursive(Node current, int value) {
    if (current == null) {
        return false;
    } 
    if (value == current.value) {
        return true;
    } 
    return value < current.value
      ? containsNodeRecursive(current.left, value)
      : containsNodeRecursive(current.right, value);
}
```

二叉搜索树的删除（递归）

```
private Node deleteRecursive(Node current, int value) {
    if (current == null) {
        return null;
    }
 
    if (value == current.value) {
       //没有子节点
       if (current.left == null && current.right == null) {
    		return null;
		}
		//只有一个节点
		if (current.right == null) {
   			 return current.left;
			}
 
		if (current.left == null) {
   			 return current.right;
		}
		//有两个子节点
		if(current.left != null && current.right != null)
		{
			int smallestValue = findSmallestValue(current.right);
			current.value = smallestValue;
			current.right = deleteRecursive(current.right, smallestValue);
			return current;
		}
		
    } 
    if (value < current.value) {
        current.left = deleteRecursive(current.left, value);
        return current;
    }
    if(value > current.value)
    {
        current.right = deleteRecursive(current.right, value);
    	return current;
    }
}
private int findSmallestValue(Node root) {
    return root.left == null ? root.value : findSmallestValue(root.left);
}
```



## 堆

### 特性

1. 堆是一个完全二叉树
2. 堆中每一个节点的值都必须大于等于其子树中的每个节点的值(大顶堆)，或小于等于其子树中每个节点的值(小顶堆)。

堆是一个完全二叉树，所以可以使用数组进行存储。 如果根节点存储在下标为 0 的位置，那么下标的计算公式为：

```
下标为 i 的节点的左子节点的下标为 2 * i + 1
下标为 i 的节点的右子节点的下标为 2 * i + 2
下标为 i 的节点的父节点的下标为 Math.floor((i - 1) / 2)
```

### 堆的核心操作

#### 1. 往堆中插入一个元素

插入元素之后，我们需要继续满足堆的两个特性 让其重新满足堆的特性的这个过程，我们称之为 **堆化(heapify)**。

#### 2. 删除堆顶元素 (取最大值/最小值)

### 堆的应用

- top K 问题，比如，从几十亿条订单日志中筛选出金额靠前的1000条数据，构建一个容量为 K 的小顶堆
- 实现优先队列

