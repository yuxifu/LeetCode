/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-10
 */
/*
   Given a linked list, reverse the nodes of a linked list k at a time
   and return its modified list.

   If the number of nodes is not a multiple of k then left-out nodes
   in the end should remain as it is.

   You may not alter the values in the nodes, only nodes itself may be changed.

   Only constant memory is allowed.

   For example,
   Given this linked list: 1->2->3->4->5
   For k = 2, you should return: 2->1->4->3->5
   For k = 3, you should return: 3->2->1->4->5
 */

import java.util.*;

public class ReverseNodesInKGroup {

// Definition for singly-linked list.
public static class ListNode {
int val;
ListNode next;
ListNode(int x) {
        val = x;
        next = null;
}
}

//hard to understand: 12/12, need a new solution
// Time: o(n)
// Space: o(1)
public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int cnt = 0;
        // get next group
        while (cur != null && cnt != k) {
                cur = cur.next;
                cnt++;
                if(cur!=null)
                {
                System.out.println("cur val=" + cur.val+ " cnt="+cnt);
            }
        }
        if (cnt == k) {
                cur = reverseKGroup(cur, k);
                // reverse
                while (0 <= --cnt) {
                    System.out.println("head=" + head.val+ " cur="+cur.val);
                    ListNode tmp = head.next;
                        head.next = cur;
                        cur = head;
                        head = tmp;
                }
                head = cur;
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
        ListNode list = numbersToList(new int[] {0,2,4,7,8,9,1,3});
        ReverseNodesInKGroup s = new ReverseNodesInKGroup();
        System.out.println("List: " + listToString(list));
        System.out.println("Result 3: " + listToString(s.reverseKGroup(list,3)));
}
}
