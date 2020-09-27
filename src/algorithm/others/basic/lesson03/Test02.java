package algorithm.others.basic.lesson03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/8 16:20
 * <p>
 * 队列实现栈
 * 栈实现队列
 */
public class Test02 {

    class TwoStackConvertQueue {
        private Stack<Integer> stackData;
        private Stack<Integer> stackHelp;

        public TwoStackConvertQueue() {
            this.stackData = new Stack<>();
            this.stackHelp = new Stack<>();
        }

        public void push(Integer x) {
            stackData.push(x);
        }

        public Integer pop() {
            if (stackHelp.isEmpty() && stackData.isEmpty()) {
                throw new RuntimeException();
            }

            if (stackHelp.isEmpty()) {
                while (!stackData.isEmpty()) {
                    stackHelp.push(stackData.pop());
                }
            }
            return stackHelp.pop();
        }

        public Integer peek() {
            if (stackHelp.isEmpty() && stackData.isEmpty()) {
                throw new RuntimeException();
            }

            if (stackHelp.isEmpty()) {
                while (!stackData.isEmpty()) {
                    stackHelp.push(stackData.pop());
                }
            }
            return stackHelp.peek();

        }
    }

    class TwoQueueConvertStack {
        private Queue<Integer> queueData;
        private Queue<Integer> queueHelp;

        public TwoQueueConvertStack() {
            this.queueData = new LinkedList<>();
            this.queueHelp = new LinkedList<>();
        }

        public void push(int x) {
            queueData.add(x);
        }

        public int pop() {
            if (queueData.isEmpty() && queueHelp.isEmpty()) {
                throw new RuntimeException();
            }
            while (queueData.size() > 1) {
                queueHelp.add(queueData.poll());
            }

            int y = queueData.poll();

            Queue<Integer> temp = queueData;
            queueData = queueHelp;
            queueHelp = temp;

            return y;

        }

        public int peek() {

            if (queueData.isEmpty() && queueHelp.isEmpty()) {
                throw new RuntimeException();
            }
            while (queueData.size() > 1) {
                queueHelp.add(queueData.poll());
            }

            int y = queueData.poll();
            queueHelp.add(y);

            Queue<Integer> temp = queueData;
            queueData = queueHelp;
            queueHelp = temp;

            return y;

        }
    }
}
