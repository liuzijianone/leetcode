package algorithm.CodingInterviews.Test09;

import java.util.Stack;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/8 17:27
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
