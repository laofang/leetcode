/**
 * Leetcode876题，链表的中间结点
 * 关键字：链表、双指针
 * 主要思路：
 * 1. 先求出结点总数，再求出定义的中位数
 * 2. 找到中位数的位置的结点
 */
public class LC876 {
    public ListNode middleNode(ListNode head) {
        int cnt = 0;
        ListNode h = head;
        while(h != null) {
            cnt++;
            h = h.next;
        }
        cnt = cnt / 2 + 1;
        h = head;
        for(int i = 0; i < cnt - 1; i++) {
            h = h.next;
        }
        return h;
    }
}
