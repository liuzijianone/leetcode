package algorithm.CodingInterviews.Test22;

import java.util.List;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/1 18:54
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
