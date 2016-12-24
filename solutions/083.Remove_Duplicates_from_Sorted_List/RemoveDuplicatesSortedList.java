/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-23
 */
/*
Given a sorted linked list, delete all duplicates such that each element
appear only once.
For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
 */


import java.util.*;

public class RemoveDuplicatesSortedList {

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
public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode cur = head;
        while(cur.next!=null)
        {
                if(cur.val == cur.next.val) {
                        cur.next = cur.next.next;
                } else {
                        cur = cur.next;
                }
        }
        return head;
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
        ListNode list1 = numbersToList(new int[] {1,1,2,3,3});
        RemoveDuplicatesSortedList s = new RemoveDuplicatesSortedList();
        System.out.println("List 1: " + listToString(list1));
        System.out.println("Result: " + listToString(s.deleteDuplicates(list1)));
}
}
