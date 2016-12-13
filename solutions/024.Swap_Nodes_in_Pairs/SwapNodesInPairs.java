/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-10
 */
/*
   Given a linked list, swap every two adjacent nodes and return its head.
   For example,
   Given 1->2->3->4, you should return the list as 2->1->4->3.

   Your algorithm should use only constant space. You may not modify the
   values in the list, only nodes itself can be changed.
 */


import java.util.*;

public class SwapNodesInPairs {

// Definition for singly-linked list.
public static class ListNode {
int val;
ListNode next;
ListNode(int x) {
        val = x;
        next = null;
}
}

// Time: o(n)
// Space: o(1)
public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while(cur!=null)
        {
                ListNode next = cur.next;
                if(next==null) {
                        break;
                }
                ListNode nextNext = next.next;
                if(nextNext==null) {
                        break;
                }
                ListNode newNode = nextNext.next;
                cur.next = nextNext;
                nextNext.next = next;
                next.next = newNode;
                cur = next;
        }
        return dummy.next;
}

//create a list from a number array
public static ListNode numbersToList(int[] numbers) {
        if(numbers == null || numbers.length==0) {
                return null;
        } else {
                ListNode list = new ListNode(numbers[0]);
                ListNode p = list;
                for(int i=1; i<numbers.length; i++) {
                        p.next = new ListNode(numbers[i]);
                        p = p.next;
                }
                return list;
        }
}

//convert List to String
public static String listToString(ListNode list) {
        StringBuilder sb = new StringBuilder();
        while(list!=null) {
                sb.append(list.val+" ");
                list = list.next;
        }
        if(sb.length()==0) {
                sb.append("EMPTY");
        }
        return sb.toString();
}

// debug
public static void main(String[] args) {
        ListNode list = numbersToList(new int[] {0,2,4,7,8});
        SwapNodesInPairs s = new SwapNodesInPairs();
        System.out.println("List: " + listToString(list));
        System.out.println("Result: " + listToString(s.swapPairs(list)));
}
}
