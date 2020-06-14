class MyCircularDeque {

    private int length;

    private int count;

    private Node head = new Node(-1);


    
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
       length = k;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(count < length)
        {
            Node node = new Node(value);
            Node temp = head.next;
            head.next = node;
            node.next =  temp;
            count ++;
            return true;
        }else
        {
            return  false;
        }


    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(count < length)
        {
            Node node = new Node(value);
            Node temp = head;
            while(temp.next!= null)
            {
                temp  = temp.next;
            }
            temp.next =  node;
            count ++;
            return true;
        }else
        {
            return  false;
        }
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
       if(count > 0)
        {
            Node temp = head.next;
            head.next = temp.next;
            count --;
            return true;
        }else
        {
            return  false;
        }

    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(count > 0)
        {
            Node temp = head;
            Node lastSecond = head;
            while(temp.next!= null)
            {
                lastSecond = temp;
                temp  = temp.next;
            }
            lastSecond.next = null;
            count --;
            return true;
        }else
        {
            return  false;
        }
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
         if(count > 0)
        {
           return head.next.val;
        }else{
            return head.val;
        }
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if(count > 0)
        {
            Node temp = head;
            while(temp.next!= null)
            {
                temp  = temp.next;
            }
            return temp.val;
        }else{
            return head.val;
        }
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return count == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
return count == length;
    }
    class Node
    {
        int val;
        Node next;
        public Node(int val)
        {
            this.val = val;
        }
        public Node(int val,Node node)
        {
            this.val = val;
            this.next = node;
        }

    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */