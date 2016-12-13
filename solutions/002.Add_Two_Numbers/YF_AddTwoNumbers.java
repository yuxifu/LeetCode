/*
 *  Author:      Yuxi Fu
 *  File:        YF_AddTwoNumbers.java
 *  Create Date: 2016-11-30
 */
/*
   You are given two linked lists representing two non-negative numbers.
   The digits are stored in reverse order and each of their nodes contain a single
   digit. Add the two numbers and return it as a linked list.
   Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
   Output: 7 -> 0 -> 8
 */

import java.util.Scanner;

public class YF_AddTwoNumbers {

// Definition for singly-linked list.
public static class ListNode {
int val;
ListNode next;
ListNode(int x) {
        val = x;
        next = null;
}
}

//from illuz, AC_simulation_n.java
public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(0);
        ListNode cur = ret;

        int sum = 0;
        while (true) {
                if (l1 != null) {
                        sum += l1.val;
                        l1 = l1.next;
                }
                if (l2 != null) {
                        sum += l2.val;
                        l2 = l2.next;
                }
                cur.val = sum % 10;
                sum /= 10;
                if (l1 != null || l2 != null || sum != 0) {
                        cur = (cur.next = new ListNode(0));
                } else {
                        break;
                }
        }
        return ret;
}

//from https://leetcode.com/articles/add-two-numbers/
/* Complexity Analysis
   Time complexity : O(max(m, n)). Assume that mm and n represents the length
   of l1 and l2 respectively, the algorithm above iterates at most max(m,n)
   times.
   Space complexity : O(max(m, n)). The length of the new list is at most
   max(m,n)+1.
 */
public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
                int x = (p != null) ? p.val : 0;
                int y = (q != null) ? q.val : 0;
                int sum = carry + x + y;
                carry = sum / 10;
                curr.next = new ListNode(sum % 10);
                curr = curr.next;
                if (p != null) p = p.next;
                if (q != null) q = q.next;
        }
        if (carry > 0) {
                curr.next = new ListNode(carry);
        }
        return dummyHead.next;
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

//test case
public static void test(int[] list1, int[] list2){
        ListNode l1 = numbersToList(list1);
        ListNode l2 = numbersToList(list2);
        System.out.println(listToString(l1));
        System.out.println(listToString(l2));
        System.out.println("addTwoNumbers: "+listToString(addTwoNumbers(l1,l2)));
        System.out.println("addTwoNumbers2: "+listToString(addTwoNumbers2(l1,l2)));
}

//testing
public static void main(String[] args) {
        //base case
        test(new int[] {2,4,3},new int[] {5,6,4});
        test(new int[] {0,1},new int[] {0,1,2});
        test(new int[] {},new int[] {0,1});
        test(new int[] {9,9},new int[] {1});
}

//
}
