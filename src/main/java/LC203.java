/**
 * Leetcode203题,移除链表元素
 * 关键字：递归，链表
 * 主要思路：
 * 1. 移除指定元素，前一个元素的指针指向当前的下一个元素
 */
public class LC203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode h = new ListNode();
        h.next = head;
        ListNode pre = h;
        ListNode cur = head;
        while(cur != null) {
            if(cur.val == val) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return h.next;
    }
}
