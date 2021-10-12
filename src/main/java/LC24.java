/**
 * Leetcode24题，两两交换链表中的节点
 * 用时：4m17s
 * 关键字：链表，递归，交换
 * 主要思路：
 * 1. 还是用递归的思想，要想两两交换，只要将头和其后的节点两两交换，再连上交换完成的链表即可
 * 2. 这也是看到提示说递归才想到的，有意思
 */
public class LC24 {
    public ListNode swapPairs(ListNode head) {
        //如果头为空，那么是交换完了
        if(head == null) {
            return null;
        }
        //这是奇数情况下的最后一个结点
        if(head.next == null) {
            return head;
        }
        //交换过程
        ListNode tempNode = new ListNode();
        tempNode = head.next;
        head.next = tempNode.next;
        tempNode.next = head;
        //交换后的第二个节点连接之后的链表
        head.next = swapPairs(head.next);
        return tempNode;
    }
}
