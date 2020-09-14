package algorithm.CodingInterviews.Test24;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/1 19:20
 *  定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 */
public class Test24 {
    public static void main(String[] args) {

    }

    public static ListNode reverseList(ListNode head){
        if (head == null){
            return null;
        }

        if (head.next == null){
            return head;
        }

        ListNode empty = new ListNode(0);

        ListNode temp = head;


        while (temp != null){
            ListNode node = temp.next;
            temp.next = empty.next;
            empty.next = temp;
            temp= node;
        }


        return empty.next;

    }

}

class ListNode{
    int val;
    ListNode next;
    ListNode (int x){
        val = x;
    }
}
