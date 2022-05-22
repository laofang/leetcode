/**
 * Leetcode206题，反转链表
 * 关键字：递归、链表
 * 主要思路:
 * 1. 头插法
 */
public class LC206 {
    public ListNode reverseList(ListNode head) {
        ListNode h = new ListNode();
        ListNode cur = head;
        while(cur != null) {
            ListNode temp = cur;
            cur = cur.next;
            temp.next = h.next;
            h.next = temp;
        }
        return h.next;
    }
}
