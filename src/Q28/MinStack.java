
/**
 * //Sourabh Tantuway, Shivam Gautam
 * //SXT200011, SXG200011
 * //Section: 001

 PROBLEM STATEMENT: [Stack, LinkedList]

     Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

     Implement the MinStack class:

     MinStack() initializes the stack object.
     void push(int val) pushes the element val onto the stack.
     void pop() removes the element on the top of the stack.
     int top() gets the top element of the stack.
     int getMin() retrieves the minimum element in the stack.
     You must implement a solution with O(1) time complexity for each function


 link:https: https://leetcode.com/problems/min-stack/description/

 **/

package Q28;

public class MinStack {
    private Node head;

    public MinStack() {

    }

    public void push(int x) {
        if(head == null){
            head = new Node(x, x, null);
        }else{
            head = new Node(x, Math.min(x, head.min), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    private class Node{
        int val;
        int min;
        Node next;

        private Node(int val, int min, Node next){
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    public void print(){
        System.out.print("Stack currently is: ");
        Node temp = head;
        while(temp != null){
            System.out.print(", " +temp.val);
            temp = temp.next;
        }
        System.out.println("");
    }

    public static void main(String[] args){

        MinStack minStack = new MinStack();
        System.out.println("inserting -2 ");
        minStack.push(-2);
        minStack.print();
        System.out.println("inserting 0 ");
        minStack.push(0);
        minStack.print();
        System.out.println("inserting -3 ");
        minStack.push(-3);
        minStack.print();
        System.out.println("getting min :  " + minStack.getMin()); // return -3

        System.out.println("popping from stack ");
        minStack.pop();
        minStack.print();

        System.out.println("top of stack " + minStack.top()); // return 0

        System.out.println("getting min :  " + minStack.getMin()); // return -2
    }

}

//Complexity Analysis:
/**
 * TC : O(1)  , all operations
 * SC : O(n)  , stack size at any time
 */
