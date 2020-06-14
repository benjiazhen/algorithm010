/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return iteration(l1,l2);
    }
    //1.迭代
    //时间复杂度:O(m+n)
    //空间复杂度:O(1)
    public ListNode iteration(ListNode l1, ListNode l2)
    {
        ListNode newLink = new ListNode(-1);
        ListNode pre = newLink;
        while(l1 != null && l2 != null)
        {
            if(l1.val <= l2.val)
            {
                pre.next = l1;
                l1 = l1.next;
            }else
            {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return newLink.next;

    }
    //2.递归
    //时间复杂度:O(m+n)
    //空间复杂度:O(m+n)
    public ListNode recurse(ListNode list1,ListNode list2)
    {
        if(list1 == null)
        {
            return list2;
        }
        else if(list2 == null)
        {
            return list1;
        }
        else if(list1.val <= list2.val)
        {
            list1.next = recurse(list1.next,list2);
            return list1;
        }else
        {
            list2.next = recurse(list1,list2.next);
            return list2;
        }
    }
}