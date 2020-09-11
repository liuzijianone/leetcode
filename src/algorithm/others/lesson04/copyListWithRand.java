package algorithm.others.lesson04;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/11 15:22
 */
public class copyListWithRand {
    public static void main(String[] args) {
        ListNode head = null;
        ListNode res1 = null;

        res1 = copyListWithRand(head);
        printRandLinkedList(res1);
        printRandLinkedList(head);
        System.out.println("=========================");

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.random = head.next.next.next.next.next; // 1 -> 6
        head.next.random = head.next.next.next.next.next; // 2 -> 6
        head.next.next.random = head.next.next.next.next; // 3 -> 5
        head.next.next.next.random = head.next.next; // 4 -> 3
        head.next.next.next.next.random = null; // 5 -> null
        head.next.next.next.next.next.random = head.next.next.next; // 6 -> 4

        printRandLinkedList(head);
        res1 = copyListWithRand(head);
        printRandLinkedList(res1);
        printRandLinkedList(head);
        System.out.println("=========================");



    }

    public static ListNode copyListWithRand(ListNode head){
        if (head == null){
            return null;
        }else if (head.next == null){
            if (head.random == null){
                return new ListNode(head.val);
            }
            else{
                ListNode node = new ListNode(head.val);
                node.random = node;
                return node;
            }
        }

        ListNode temp = head;
        while(temp != null){
            ListNode node = new ListNode(temp.val);
            node.next = temp.next;
            temp.next = node;
            temp = node.next;
        }

        temp = head;

        while (temp != null){
            ListNode node = temp.next;
            if (temp.random != null){
                node.random = temp.random.next;
            }
            temp = node.next;
        }

        temp = head;
        ListNode newHead = head.next;
        ListNode node = newHead;

        head.next = node.next;
        head = head.next;
        while (head != null){
            node.next = head.next;
            node = node.next;
            head.next = node.next;
            head = head.next;
        }
        return newHead;

    }
    public static void printRandLinkedList(ListNode head) {
        ListNode cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.random == null ? "- " : cur.random.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

}

class ListNode{
    int val;
    ListNode next;
    ListNode random;

    ListNode(int x){
        val = x;
    }
}