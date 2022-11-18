
/**
 * //Sourabh Tantuway, Shivam Gautam
 * //SXT200011, SXG200011
 * //Section: 001

 PROBLEM STATEMENT: [LinkedList]

    Given the head of a singly linked list, reverse the list, and return the reversed list.
 I  nput: head = [1,2,3,4,5]
    Output: [5,4,3,2,1]

    link:https: https://leetcode.com/problems/reverse-linked-list/description/

 **/

package Q31;

import Q29.SortList;

import java.util.HashMap;

public class ReverseLL {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reverseList(ListNode head) {
        return reverse(head,null);
    }

    public static ListNode reverse(ListNode node,ListNode prev){
        if(node==null)
            return prev;
        ListNode next = node.next;
        node.next = prev;
        return reverse(next,node);

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

        System.out.println("List before reversing ");
        print(a);
        a = reverseList(a);
        System.out.println("List after reversing ");
        print(a);
    }

}

//Complexity Analysis:
/**
 * TC : O(n)  , one traversal of the n length linked list
 * SC : O(1)  , No additional space required
 */
