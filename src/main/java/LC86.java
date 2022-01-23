/**
 * Leetcode86题，分隔链表
 * 关键字：链表、头插法
 * 主要思路：
 * 1. 定位大于等于x的位置
 * 2. 遍历这个位置之后的结点
 * 3. 之后的结点如果 < x，那就插入到找到位置的前面
 */
public class LC86 {
    public ListNode partition(ListNode head, int x) {
        ListNode h = new ListNode();
        //可能第一个结点就大于x，那就要用头插法
        ListNode ans = h;
        h.next = head;
        //找到 >=x 的位置
        while(h.next != null && h.next.val < x) {
            h = h.next;
        }
        //h.next.val >= x , h.val < x
        ListNode cur = h.next;
        while(cur != null) {
            //遍历cur之后的每一个结点，如果比x小
            if(cur.next != null && cur.next.val < x) {
                //将cur后面的结点摘下来，放到h之后，cur位置不动，h后移
                ListNode temp = cur.next;
                cur.next = temp.next;
                temp.next = h.next;
                h.next = temp;
                h = temp;
                //如果比x大，cur后移
            } else {
                cur = cur.next;
            }

        }
        return ans.next;
    }
}
