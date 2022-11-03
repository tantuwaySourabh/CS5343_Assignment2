package Q22;

import java.util.Stack;
/*
 * https://leetcode.com/problems/min-stack/
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * 
 * Implement the MinStack class:
 *  MinStack() initializes the stack object.
 *  void push(int val) pushes the element val onto the stack.
 *  void pop() removes the element on the top of the stack.
 *  int top() gets the top element of the stack.
 *  int getMin() retrieves the minimum element in the stack.
 * 
 * You must implement a solution with O(1) time complexity for each function.
 * 
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 * 
 */
public class MinStack {
    private Stack<int[]> stack = new Stack<>();
    
    public void push(int val) {
        if(stack.isEmpty()) {
            stack.push(new int[]{val,val});
            return;
        }
        
        int currMin = stack.peek()[1];
        stack.push(new int[] {val, Math.min(val, currMin)});
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        System.out.println(stack.peek()[0]);
        return stack.peek()[0];
    }
    
    public int getMin() {
        System.out.println(stack.peek()[1]);
        return stack.peek()[1];
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin(); // return -3
        minStack.pop();
        minStack.top();    // return 0
        minStack.getMin(); // return -2

    }
}
/*
 * Time Complexity: O(1)
 */
