/**
 * Leetcode1669题，合并两个链表
 * 关键字：链表
 * 主要思路：
 * 1. 先找到a的前一位置，再找到b的位置
 * 2. a的前一位置连上list2的头
 * 3. list2的尾连接上b位置后面的元素
 */
public class LC1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        ListNode l2Tail = list2;
        //找到List2的尾部
        while(l2Tail.next != null) l2Tail = l2Tail.next;

        //找到第a-1的位置
        ListNode first = list1;
        int i = 0;
        while(i < a - 1) {
            first = first.next;
            ++i;
        }

        i = 0;
        ListNode second = first;
        int cnt = b - a;
        //找到第b的位置
        while(i < cnt + 1) {
            second = second.next;
            ++i;
        }
        //a-1位置后连上List2的头
        first.next = list2;
        //List2的尾连接上b的后面
        l2Tail.next = second.next;

        return list1;
    }
}
