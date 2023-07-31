/**
 * Leetcode143题，重排链表
 * 关键字：栈、递归、链表、双指针
 * 主要思路：
 * 1. 数组双指针，先将链表放入数组
 * 2. 根据题意进行模拟，将链表节点连上
 */
public class LC143 {
    public void reorderList(ListNode head) {
        int cnt = 0;
        ListNode p = head;
        while(p != null) {
            cnt++;
            p = p.next;
        }
        ListNode[] array = new ListNode[cnt];
        int i = 0, j = array.length - 1;
        p = head;
        while(p != null) {
            array[i++] = p;
            p = p.next;
        }
        i = 0;
        p = new ListNode();
        while(i <= j) {
            array[i].next = array[j];
            p.next = array[i];
            p = array[j];
            i++;
            j--;

        }
        p.next = null;
    }
}
