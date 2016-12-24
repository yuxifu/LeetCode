/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-19
 */
/*
   Given a list, rotate the list to the right by k places, where k is non-negative.
   For example:
   Given 1->2->3->4->5->NULL and k = 2,
   return 4->5->1->2->3->NULL.

   Solution: Notice that k can be larger than the list size (k % list_size).
          This solution traverses the list twice at most.
 */

import java.util.*;

public class RotateList {

public static class ListNode {
int val;
ListNode next;
ListNode(int x) {
        val = x;
}
}

// Time: o(n)
// Space: o(1)
public ListNode rotateRight(ListNode head, int k) {
    if (head == null) return head;
    int n = 1;
    ListNode tail = head, cur = head;
    while (tail.next != null) {
        tail = tail.next;
        ++n;
    }
    k = k % n;
    if (k == 0) return head;
    for (int i = 0; i < n - k - 1; ++i)
        cur = cur.next;
    ListNode newHead = cur.next;
    tail.next = head;
    cur.next = null;
    return newHead;
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
        RotateList s = new RotateList();
        System.out.println("Source: " + listToString(list));
        ListNode result = s.rotateRight(list,2);
        System.out.println("Result: " + listToString(result));
}

}
