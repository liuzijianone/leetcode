package algorithm.CodingInterviews.Test22;

import java.util.List;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/1 18:54
 *  输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *  例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 *
 */
public class Test22 {
    public static void main(String[] args) {

    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null){
            return null;
        }
        if (head.next == null){
            return head;
        }

        ListNode node = head;
        ListNode temp = head;

        for (int i = 0; i < k -1; i++){
            if (node.next == null){
                return null;
            }
            node = node.next;
        }

        while (node.next != null){
            node = node.next;
            temp = temp.next;
        }

        return  temp;

    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode (int x){
        val = x;
    }
}
