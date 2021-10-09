/**
 * Leetcode第十九题，删除链表的倒数第N个节点
 * 用时：4m49s
 * 最开始想到的也是循环两次，第一次知道链表长度，第二次找到倒数第n-1个
 * 看了解析知道可以用快，慢指针解决
 * 注意事项：
 * 1. 最好有个头节点，这样删除的话，可以统一处理
 * 2. 倒数第一个节点就是快指针指向的，所以慢节点应是快指针要先移动n个，然后慢指针和快指针同时后移，quick.next==null时，则quick指向倒数第一个节点，slow就是倒数第n-1个节点
 */
public class LC19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = new ListNode();
        first.next = head;
        ListNode h1 = first;
        ListNode h2 = first;
        //quick指针先行n次
        for (int i = 0; i < n; i++) {
            h2 = h2.next;
        }
        //再同时移动，直到quick.next = null
        //此时quick是倒数第一个节点，slow指向倒数第n-1个节点
        while(h2.next != null) {
            h1 = h1.next;
            h2 = h2.next;
        }
        //删除第n个节点
        h1.next = h1.next.next;
        return first.next;
    }
}
