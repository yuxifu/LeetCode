/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-08
 */
/*
   Given a linked list, remove the nth node from the end of list and return its head.
   For example,
   Given linked list: 1->2->3->4->5, and n = 2.
   After removing the second node from the end, the linked list
   becomes 1->2->3->5.
 */

import java.util.*;

public class RemoveNthNodeFromEnd {

public static class ListNode {
int val;
ListNode next;
ListNode(int x) {
        val = x;
}
}

// Time: o(n)
// Space: o(1)
public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode p2 = dummy;

        //move p1 n steps first
        for(int i=0; i<n; i++) {
                if(p1.next==null) {
                        return dummy.next;
                }
                p1 = p1.next;
        }

        //move together
        while(p1.next!=null) {
                p1= p1.next;
                p2= p2.next;
        }

        //delete the target node
        p2.next = p2.next.next;

        //return;
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
        ListNode list = numbersToList(new int[] {1,2,3,4,5});
        RemoveNthNodeFromEnd s = new RemoveNthNodeFromEnd();
        System.out.println("Source: " + listToString(list));
        ListNode result = s.removeNthFromEnd(list,6);
        System.out.println("Result: " + listToString(result));
}

}
