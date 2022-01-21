/**
 * Leetcode83题，删除排序链表中的重复元素
 * 关键字：链表、删除重复元素
 * 主要思路：
 * 1. 两个指针
 * 2. 后一个指针走到一个与之前不相等的停下
 * 3. 前一个指针指向后一个指针，并移到后一个指针
 * 4. 重复2过程
 */
public class LC83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        ListNode move = cur;
        while(cur != null) {
            move = cur;
            while(move.next != null && move.val == move.next.val) {
                move = move.next;
            }
            cur.next = move.next;
            cur = cur.next;
        }
        return head;
    }
}
