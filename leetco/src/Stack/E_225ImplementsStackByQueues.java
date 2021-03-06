package Stack;

import java.util.LinkedList;
import java.util.Queue;

public class E_225ImplementsStackByQueues {
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    /** Initialize your data structure here. */
    public void MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while(q1.size() > 1){
            q2.offer(q1.poll());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return q2.poll();
    }

    /** Get the top element. */
    public int top() {
        int temp = pop();
        q1.offer(temp);
        return temp;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(q1.isEmpty() && q2.isEmpty()){
            return true;
        }
        return false;
    }
}
