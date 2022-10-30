
/**
 * //Sourabh Tantuway, Shivam Gautam
 * //SXT200011, SXG200011
 * //Section: 001

 PROBLEM STATEMENT:
 Given the heads of two singly linked-lists headA and headB,
 return the node at which the two lists intersect.
 If the two linked lists have no intersection at all, return null

 link: https://leetcode.com/problems/intersection-of-two-linked-lists/
 **/

package Q1;
public class IntersectNode {

    public static void main(String[] args){

        //code for generating 2 linked lists.
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(5);
        a.next = new ListNode(1);
        b.next = new ListNode(6);
        b.next.next = new ListNode(1);
        a.next.next = b.next.next.next = new ListNode(8);
        a.next.next.next = b.next.next.next.next = new ListNode(4);
        a.next.next.next.next = b.next.next.next.next.next = new ListNode(5);

        //Linked List A is [4,1,8,4,5],
        //Linked List B is  [5,6,1,8,4,5]
        //both lists are intersecting at 8


        System.out.println("Intersected node value is " + getIntersectionNode(a,b).val);
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        if(headA == null || headB == null) return null;

        while(temp1 != temp2){
            if(temp1 == null){
                temp1 = headB;
            }else
                temp1 = temp1.next;
            if(temp2 == null){
                temp2 = headA;
            }else
                temp2 = temp2.next;
        }
        if(temp1 == null)
            return null;
        else
            return temp1;

    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
}