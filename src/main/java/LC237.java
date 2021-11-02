/**
 * LC237题，删除链表中的节点
 * 关键字：链表
 * 主要思路：
 * 1. 当前节点的值改为下个节点的，然后next指针往后移一下
 */
public class LC237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
