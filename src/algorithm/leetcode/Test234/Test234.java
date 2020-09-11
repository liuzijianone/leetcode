package algorithm.leetcode.Test234;

import java.util.Stack;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/11 14:47
 */
public class Test234 {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
            return true;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null){
            stack.add(temp);
            temp = temp.next;
        }
        temp = head;

        while(!stack.isEmpty()){
            if (stack.pop().val != temp.val){
                return false;
            }
            temp = temp.next;
        }
        return  true;
    }

    public boolean isPalindrome01(ListNode head) {
        if (head == null || head.next == null){
            return true;
        }
        ListNode right = head;
        ListNode left = right;
        while (right.next != null && right.next.next != null){
            right = right.next.next;
            left = left.next;
        }

        if (right.next != null){
            right = right.next;
        }

        ListNode medium = left;


        left = left.next;
        medium.next = null;

        while (left != null){
            ListNode node = left.next;
            left.next = medium.next;
            medium.next = left;
            left = node;
        }

        left = head;
        ListNode temp = medium.next;
        while (temp != null){
            // while (left != medium) 错误
            if (left.val != temp.val){
                return  false;
            }
            left = left.next;
            temp = temp.next;
        }

        medium.next = null;

        while (right != null){
            ListNode node = right.next;
            right.next = medium.next;
            medium.next = right;
            right = node;
        }

        return true;
    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode (int x){
        val = x;
    }
}
