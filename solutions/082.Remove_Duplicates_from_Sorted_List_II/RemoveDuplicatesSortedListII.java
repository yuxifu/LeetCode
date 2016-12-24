/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-23
 */
/*
   Given a sorted linked list, delete all nodes that have duplicate
   numbers, leaving only distinct numbers from the original list.
   For example,
   Given 1->2->3->3->4->4->5, return 1->2->5.
   Given 1->1->1->2->3, return 2->3.
 */

import java.util.*;

public class RemoveDuplicatesSortedListII {

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
// Space: o(n)
public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (head != null) {
                if (head.next != null && head.val == head.next.val) {
                        while (head.next != null && head.val == head.next.val)
                                head = head.next;
                } else {
                        cur.next = head;
                        cur = cur.next;
                }
                head = head.next;
        }
        cur.next = null;
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
        ListNode list1 = numbersToList(new int[] {1,1,2,3,3,4});
        RemoveDuplicatesSortedListII s = new RemoveDuplicatesSortedListII();
        System.out.println("List 1: " + listToString(list1));
        System.out.println("Result: " + listToString(s.deleteDuplicates(list1)));
}
}
