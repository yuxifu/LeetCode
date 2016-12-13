/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-09
 */
/*

 */

import java.util.*;

public class Common {

public static class ListNode {
int val;
ListNode next;
ListNode(int x) {
        val = x;
}
}

//create a linked list from a number array
public static ListNode numbersToLinkedList(int[] numbers) {
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

//convert Linked List to String
public static String linkedListToString(ListNode list) {
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

//convert list to String
public static String listToString(List<string> list) {
        StringBuilder sb = new StringBuilder();
        return sb.toString();
}

// test
public static void main(String[] args) {
        ListNode list1 = numbersToLinkedList(new int[] {1,3,5});
        ListNode list2 = numbersToLinkedList(new int[] {0,2,4,7,8});
        System.out.println("List 1: " + linkedListToString(list1));
        System.out.println("List 2: " + linkedListToString(list2));

}

}
