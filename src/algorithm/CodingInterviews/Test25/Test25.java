package algorithm.CodingInterviews.Test25;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/1 19:41
 */
public class Test25 {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null){
            return l2;
        }

        if (l2 == null){
            return l1;
        }

        ListNode empty1 = new ListNode(0);
        ListNode empty2 = new ListNode(0);
        ListNode empty3 = new ListNode(0);

        empty1.next = l1;
        empty2.next = l2;
        ListNode r = empty3;


        while ( l1 != null && l2 !=null){
            if (l1.val <= l2.val){
                empty1.next = l1.next;
                r.next = l1;
                l1=empty1.next;
            }else {
                empty2.next = l2.next;
                r.next = l2;
                l2=empty2.next;
            }
            r = r.next;
        }

        if (l1 == null){
            r.next = l2;
        }
        else{
            r.next = l1;
        }
        return empty3.next;


    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}
