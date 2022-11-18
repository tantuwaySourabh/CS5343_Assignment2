
/**
 * //Sourabh Tantuway, Shivam Gautam
 * //SXT200011, SXG200011
 * //Section: 001

 PROBLEM STATEMENT: [Sorting, LinkedList]

     Given the head of a linked list, return the list after sorting it in ascending order.

     Input: head = [4,2,1,3]
     Output: [1,2,3,4]

 link:https: https://leetcode.com/problems/sort-list/description/

 **/

package Q29;

import Q1.IntersectNode;
import Q28.MinStack;

public class SortList {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left,right);
    }

    public static ListNode merge(ListNode list1, ListNode list2){
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            }else{
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }


        }
        tail.next = (list1 != null) ? list1 : list2;
        return dummyHead.next;
    }


    public static ListNode getMid(ListNode head){
        ListNode midPrev = null;
        while(head != null && head.next != null){
            if(midPrev == null){
                midPrev = head;
            }else
                midPrev = midPrev.next;
            //midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }

        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

    public static void print(ListNode head){
        System.out.print("List is : ");
        ListNode temp = head;
        while(temp != null){
            System.out.print(", " +temp.val);
            temp = temp.next;
        }
        System.out.println("");
    }

    public static void main(String[] args){

        ListNode a = new ListNode(-1);

        a.next = new ListNode(5);
        a.next.next  = new ListNode(3);
        a.next.next.next = new ListNode(4);
        a.next.next.next.next = new ListNode(0);

        System.out.println("List before sorting ");
        print(a);
        a = sortList(a);
        System.out.println("List after sorting ");
        print(a);


    }

}

//Complexity Analysis:
/**
 * TC : O(nlogn)  ,  complexity like merge sort
 * SC : O(logn)  , call stack at any time
 */
