/**
 * Leetcode25,K个一组反转链表
 * 关键词：递归链表
 * 整体思路：
 * 1. 将前k个反转，在对其后的递归调用该方法
 * 2. 计数出错，找了好长好长时间的问题，细节要注意
 * 3. 要时刻清楚每个指针的指向
 */
public class LC25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        //当前头指针将要指向的指针
        ListNode nextNode = head;
        //当前指针
        ListNode currentNode = head;
        //找到第k+1个指针，第一个要指向的
        for (int i = 0; i < k; i++) {
            //如果为空，说明数量不够，则不变化位置，直接返回头指针即可
            if(nextNode == null) {
                return head;
            }
            nextNode = nextNode.next;
        }
        ListNode tempNode = new ListNode();
        //开始反转前k个结点
        for (int i = 0; i < k; i++) {
            tempNode = currentNode.next;
            currentNode.next = nextNode;
            nextNode = currentNode;
            currentNode = tempNode;
        }
        //此时的head指向的是第k个结点
        head.next = reverseKGroup(head.next,k);
        //nextNode是第一个结点
        return nextNode;
    }
}
