/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-09
 */
/*
   Merge two sorted linked lists and return it as a new list. The
   new list should be made by splicing together the nodes of the
   first two lists.
 */

import java.util.*;

public class MergeTwoSortedLists {

public static class ListNode {
int val;
ListNode next;
ListNode(int x) {
        val = x;
}
}

// Time: o(n)
// Space: o(1)
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                        cur.next = l1;
                        l1 = l1.next;
                } else {
                        cur.next = l2;
                        l2 = l2.next;
                }
                cur = cur.next;
        }
        if (l1 != null) cur.next = l1;
        if (l2 != null) cur.next = l2;
        return head.next;
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
        ListNode list1 = numbersToList(new int[] {1,3,5});
        ListNode list2 = numbersToList(new int[] {0,2,4,7,8});
        MergeTwoSortedLists s = new MergeTwoSortedLists();
        System.out.println("List 1: " + listToString(list1));
        System.out.println("List 2: " + listToString(list2));
        System.out.println("Result: " + listToString(s.mergeTwoLists(list1,list2)));
}

}
