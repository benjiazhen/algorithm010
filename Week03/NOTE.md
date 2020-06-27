**递归**

技巧：

1. 抛弃人肉搜索
2. 寻找重复子函数，因为程序的本质就是if/else,for while 递归
3. 根据数学归纳法寻找递推公式

模板

```
// Java
public void recur(int level, int param) { 
  // terminator 
  if (level > MAX_LEVEL) { 
    // process result 
    return; 
  }
  // process current logic 
  process(level, param); 
  // drill down 
  recur( level: level + 1, newParam); 
  // restore current status 
}

```

