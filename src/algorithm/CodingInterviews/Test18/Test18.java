package algorithm.CodingInterviews.Test18;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/1 18:39
 *
 *  给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 *
 * 注意：此题对比原题有改动
 *
 * 示例 1:
 *
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 *
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.

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
