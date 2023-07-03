import java.util.LinkedList;

/**
 * Leetcode445题，两数相加II
 * 关键字：栈、链表、数学
 * 主要思路：
 * 1. 用栈找平最低位，按加法规则相加
 */
public class LC445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<Integer> stack1 = new LinkedList<>();
        LinkedList<Integer> stack2 = new LinkedList<>();
        while(l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode head = new ListNode();
        while(stack1.size() > 0 || stack2.size() > 0 || carry > 0) {
            int a = stack1.size() > 0 ? stack1.pop() : 0;
            int b = stack2.size() > 0 ? stack2.pop() : 0;
            int val = (a + b + carry) % 10;
            carry = (a + b + carry ) / 10;
            ListNode cur = new ListNode(val);
            cur.next = head.next;
            head.next = cur;
        }
        return head.next;
    }
}
