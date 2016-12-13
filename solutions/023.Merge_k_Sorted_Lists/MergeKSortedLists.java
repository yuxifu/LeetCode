/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-10
 */
/*
   Merge k sorted linked lists and return it as one sorted list.
   Analyze and describe its complexity.
 */


import java.util.*;

public class MergeKSortedLists {

// Definition for singly-linked list.
public static class ListNode {
int val;
ListNode next;
ListNode(int x) {
        val = x;
        next = null;
}
}

// Time: o(nlogk)
// Space: o(1)
public ListNode mergeKLists(List<ListNode> lists) {
        Queue<ListNode> heap = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
                        @Override public int compare(ListNode l1, ListNode l2) {
                                return l1.val - l2.val;
                        }
                });

        ListNode dummy = new ListNode(0), cur = dummy, tmp;
        for (ListNode list : lists) {
                if (list != null) {
                        heap.offer(list);
                }
        }
        while (!heap.isEmpty()) {
                tmp = heap.poll();
                cur.next = tmp;
                cur = cur.next;
                if (tmp.next != null) {
                        heap.offer(tmp.next);
                }
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
        ListNode list1 = numbersToList(new int[] {1,3,5});
        ListNode list2 = numbersToList(new int[] {0,2,4,7,8});
        ListNode list3 = numbersToList(new int[] {-1,15});
        MergeKSortedLists s = new MergeKSortedLists();
        List<ListNode> lists = new ArrayList<ListNode>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        System.out.println("List 1: " + listToString(list1));
        System.out.println("List 2: " + listToString(list2));
        System.out.println("List 3: " + listToString(list3));
        System.out.println("Result: " + listToString(s.mergeKLists(lists)));
}
}
