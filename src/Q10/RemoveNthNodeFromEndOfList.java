package Q10;

/*
 * Given the head of a linked list, 
 * remove the nth node from the end of the list and return its head.
 * 
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 */

public class RemoveNthNodeFromEndOfList {

    public static void printList(ListNode head) {
        ListNode tmp = head;
        while(tmp !=null) {
            System.out.print(tmp.val+",");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode first = dum;
        ListNode second = dum;
        
        for(int i=1;i<=n+1;i++)first = first.next;
        
        while(first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        
        return dum.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        
        ListNode ans = removeNthFromEnd(head, 2);

        printList(ans);

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
 * TC : O(n)
 * SC: O(1)
 */


