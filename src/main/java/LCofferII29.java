import structure.Node;

/**
 * LeetcodeofferII29题，排序的循环链表
 * 关键字：链表
 * 主要思路：
 * 1. 分为四种情况
 *      1. insertVal的值在[p.val,p.next.val]中，则insertVal插入p和p.next之间
 *      2. insertVal > p.val && insertVal > p.next.val也就是大于两侧，且p.val>p.next.val情况，这说明insertVal是当前最大值，要插到头尾相交的中间
 *      3. 和上一种情况相反，insertVal是最小的值，同样放到首尾相交的中间
 *      4. 链表中所有元素相等，insertVal等于链表元素，这会绕链表一圈没找到位置，则直接插入即可
 */
public class LCofferII29 {
    public Node insert(Node head, int insertVal) {
        if(head == null) {
            head = new Node(insertVal);
            head.next = head;
            return head;
        }
        Node p = head.next;
        while(true) {
            if(p == head || p.val <= insertVal && insertVal <= p.next.val ||
                    (p.val >= insertVal && p.next.val >= insertVal ||p.val <= insertVal && p.next.val <= insertVal)
                            && p.val > p.next.val) {
                Node node = new Node(insertVal);
                node.next = p.next;
                p.next = node;
                break;
            }
            p = p.next;
        }
        return head;
    }
}
