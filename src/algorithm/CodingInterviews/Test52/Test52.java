package algorithm.CodingInterviews.Test52;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/2 19:39
 *
 * 输入两个链表，找出它们的第一个公共节点。
 */
public class Test52 {

    public static void main(String[] args) {

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getListLength(headA);
        int lengthB = getListLength(headB);

        int length = -1;
        if (lengthA >= lengthB){
            length = lengthA - lengthB;
            for (int i =0 ; i < length; i++){
                headA = headA.next;
            }
        }else{
            length = lengthB - lengthA;
            for (int i =0 ; i < length; i++){
                headB = headB.next;
            }
        }
        while(headA != null && headB != null ){
            if (headA== headB){
                return headA;
            }
            else{
                headA = headA.next;
                headB = headB.next;
            }
        }

        return null;




    }

    public static int getListLength(ListNode head){
        int length = 0;
        while (head!= null){
            length +=1;
            head = head.next;
        }
        return length;
    }
}

 class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}