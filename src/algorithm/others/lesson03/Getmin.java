package algorithm.others.lesson03;

import java.util.Stack;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/8 16:01
 *
 *  设计一个栈结构，可以在O(1)得到最小值
 */
public class Getmin {
}

class Mystatck{
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public Mystatck() {
        this.dataStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(Integer x){
        if (this.minStack.isEmpty()){
            minStack.push(x);
        }else if (x < minStack.peek()){
            minStack.push(x);
        }else{
            minStack.push(minStack.peek());
        }
        dataStack.push(x);
    }

    public Integer pop(){
        if (dataStack.isEmpty()){
            throw new RuntimeException();
        }
        this.minStack.pop();
        return this.dataStack.pop();
    }

    public Integer getMin(){
        if (minStack.isEmpty()){
            throw new RuntimeException();
        }
        return minStack.peek();
    }
}
