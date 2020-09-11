package algorithm.CodingInterviews.Test06;

import org.junit.Test;

import java.util.Stack;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/8/30 20:57
 *
 * 思路：不使用栈装结点  遍历链表一次得到链表长度，创建数组
 * 将val倒序插入到数组
 */
public class Test06 {
    @Test
    public int[] test() {
        ListNode head = null;

        ListNode node = head;
        int count = 0;

        Stack<ListNode> stack = new Stack<>();
        while (node != null){
            stack.push(node);
            node = node.next;
            count++;
        }

        int[] array = new int[count];
        for (int i =0; i < array.length; i++){
            ListNode no = stack.pop();
            array[i] = no.val;
        }
        return array;

    }

    public static int[] reversePrint(ListNode head) {
        ListNode node = head;
        int count = 0;
        while (node != null) {
            ++count;
            node = node.next;
        }
        int[] nums = new int[count];
        node = head;
        for (int i = count - 1; i >= 0; --i) {
            nums[i] = node.val;
            node = node.next;
        }
        return nums;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
