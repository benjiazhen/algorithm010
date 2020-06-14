**方法论**

五毒神掌，每道题刷5遍，刻意练习，形成条件反射

**思想**

升维+空间换时间

**解题套路**

先暴力后优化，时间+空间复杂度分析，国际站Top3解题思路

**技巧**

双端指针，双端夹逼，快慢指针

数组平移

```
nums[(i+k)%nums.length] = nums[i];
```

数组翻转

```
while(start < end)
{
	int temp = nums[end];
	int nums[end] = nums[start];
	nums[start] = temp;
}
```

**Queue源码分析：**

queue作为FIFO的数据结构，继承自Collection接口，实现类有ArrayBlockingQueue，DelayQueue，LinkedList,PriorityQueue，具有以下接口

|         | Throws Exception | Returns special value |
| ------- | ---------------- | --------------------- |
| Insert  | add(e)           | offer(e)              |
| Remove  | remove()         | poll()                |
| Examine | element()        | peek()                |

**PriorityQueue 源码分析**

| 方法名      | 时间复杂度 |
| ----------- | ---------- |
| offer(e)    | O(log(n))  |
| poll(e)     | O(log(n))  |
| remove()    | O(log(n))  |
| add(e)      | O(log(n))  |
| remove(e)   | O(n)       |
| contains(e) | O(n)       |
| peek()      | O(1)       |
| elements    | O(1)       |
| size        | O(1)       |



