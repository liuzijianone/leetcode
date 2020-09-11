package algorithm.CodingInterviews.Test18;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/1 18:39
 */
public class Test18 {
    public static void main(String[] args) {

    }

    public static ListNode deleteNode(ListNode head, int val){
        if (head == null){
            return null;
        }

        if (head.val == val){
            if (head.next == null){
                return null;
            }else{
                return head.next;
            }
        }

        ListNode node = head;
        while (node.next != null){
            if (node.next.val == val){
                break;
            }
            node = node.next;
        }

        if (node.next != null){
            node.next = node.next.next;
        }

        return head;
    }
}

class ListNode{
    int val;
    ListNode next;

    ListNode(int x){
        val = x;
    }
}
