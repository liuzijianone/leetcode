package algorithm.CodingInterviews.Test30;

import java.util.Stack;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/8 17:25
 *  定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 */
public class Test30 {

}

class MinStack {

    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        this.dataStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int x) {

        if (this.minStack.isEmpty()){
            minStack.push(x);
        }else if (x < minStack.peek()){
            minStack.push(x);
        }else{
            minStack.push(minStack.peek());
        }
        dataStack.push(x);

    }

    public void pop() {
        if (dataStack.isEmpty()){
            throw new RuntimeException();
        }
        this.minStack.pop();
        this.dataStack.pop();

    }

    public int top() {
        if (dataStack.isEmpty()){
            throw new RuntimeException();
        }
        return dataStack.peek();

    }

    public int min() {
        if (minStack.isEmpty()){
            throw new RuntimeException();
        }
        return minStack.peek();

    }
}

