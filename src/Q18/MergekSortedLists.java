package Q18;

import java.util.PriorityQueue;
import java.util.Queue;
/*
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 * 
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * 
 */
public class MergekSortedLists {

    public static void printList(ListNode head) {
        ListNode tmp = head;
        while(tmp !=null) {
            System.out.print(tmp.val+",");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> q = new PriorityQueue<ListNode>((a,b) -> a.val - b.val);
        
        for(ListNode l: lists) {
            if(l!= null) {
                q.add(l);
            }
        }
        ListNode head = new ListNode(0);
        ListNode point = head;
        while(!q.isEmpty()) {
            point.next = q.poll();
            point = point.next;
            ListNode next = point.next;
            if(next != null){
                q.add(next);
            }
        }
        return head.next;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode mergedList = mergeKLists(new ListNode[]{l1,l2,l3});
        printList(mergedList);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

/*
 * Time complexity : O(Nlogk) where k is the number of linked lists.
 */
