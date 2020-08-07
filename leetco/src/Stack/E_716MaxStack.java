package Stack;

import java.util.Stack;

public class E_716MaxStack {
    //solution1 stack + maxStack
    Stack<Integer> stack;
     Stack<Integer> maxStack;

    /** initialize your data structure here. */
    public MaxStack() {
        stack = new Stack();
        maxStack = new Stack();
    }

    public void push(int x) {
        stack.push(x);
        if(maxStack.isEmpty()){
            maxStack.push(x);
        }else{
            if(maxStack.peek() < x){
                maxStack.push(x);
            }else{
                maxStack.push(maxStack.peek());
            }
        }
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = peekMax();
        Stack<Integer> temp = new Stack();
        while(stack.peek() != max){
            temp.push(pop());
        }
        pop();
        while(!temp.isEmpty()){
            push(temp.pop());
        }
        return max;
    }
}
