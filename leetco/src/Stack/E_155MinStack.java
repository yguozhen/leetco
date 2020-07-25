package Stack;

import java.util.Stack;

public class E_155MinStack {
    private Stack<Integer> min;
    private Stack<Integer> stack;
    /** initialize your data structure here. */
    public void MinStack1() {
        min = new Stack<Integer>();
        stack = new Stack<Integer>();
    }

    public void push(int x) {
        stack.push(x);
        if(min.isEmpty()){
            min.push(x);
        }else{
            min.push(Math.min(x, min.peek()));
        }
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
