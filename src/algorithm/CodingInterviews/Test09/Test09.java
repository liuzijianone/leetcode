package algorithm.CodingInterviews.Test09;

import java.util.Stack;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/8 17:27
 *
 *  用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 *  (若队列中没有元素，deleteHead 操作返回 -1 )
 *
 */
public class Test09 {
}

class CQueue {
    private Stack<Integer> stackData;
    private Stack<Integer> stackHelp;

    public CQueue() {
        this.stackData = new Stack<>();
        this.stackHelp = new Stack<>();


    }

    public void appendTail(int value) {
        this.stackData.push(value);

    }

    public int deleteHead() {
        if(stackHelp.isEmpty() && stackData.isEmpty()){
            return -1;
        }
        if(stackHelp.isEmpty()){
            while(!stackData.isEmpty()){
                stackHelp.push(stackData.pop());
            }
        }
        return stackHelp.pop();

    }
}
