package algorithm.others.lesson04;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/11 16:09
 */
public class getIntersectNode {
    public static void main(String[] args) {

    }
    /**
      * @author liuzijian
      * @since 2020/9/11 16:29
      * @version 1.0
      * @param head
      * @return Node
     * 两个单链表相交的一系列问题
     * 	【题目】 在本题中，单链表可能有环，也可能无环。给定两个
     * 	单链表的头节点 head1和head2，这两个链表可能相交，也可能
     * 	不相交。请实现一个函数， 如果两个链表相交，请返回相交的
     * 	第一个节点；如果不相交，返回null 即可。 要求：如果链表1
     * 	的长度为N，链表2的长度为M，时间复杂度请达到 O(N+M)，额外
     * 	空间复杂度请达到O(1)。
      *
      *     1.判断链表有环无环
      *      三个以上节点的链表才可能构成环
      *      快指针走一步，慢指针走两步
      *      只要都不为空，两个指针相交的时候，快指针回到头指针位置
      *      快指针和慢指针都走一步，两指针再次相交的时候返回该节点就是有环链表第一个相交的节点
      */

    public static Node getLoopNode(Node head){
        if (head == null || head.next == null || head.next.next == null){
            return null;
        }

        Node fast = head;
        Node slow = head;

        while (slow != fast){
            if (fast.next == null || fast.next.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }


    // 只能有环链表和有环链表相交，无环链表和无环链表相交，不可能有环和无环相交
    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2){
        if ((loop1 == null && loop2 != null) || (loop1 != null && loop2 == null)){
            return null;
        }
        if (loop1 == loop2){
            // 两个无环链表求相交
            return null;
        }else{
            Node cur = loop1.next;
            while (cur != loop1){
                if (cur == loop2){
                    return loop2;
                }
                cur = cur.next;
            }
            return null;
        }

    }

}
