import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode160题，相交链表
 * 关键字：哈希表、链表、双指针
 * 主要思路：
 * 1. 遍历其中一个，存入hash表，再遍历另一个，在hash表中出现，说明这个元素就是第一个相交的
 */
public class LC160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode h1 = headA;
        ListNode h2 = headB;
        Map<ListNode,Integer> map = new HashMap<>();
        while(h1 != null) {
            map.put(h1,0);
            h1 = h1.next;
        }
        while(h2 != null) {
            if(map.get(h2) != null) return h2;
            h2 = h2.next;
        }
        return null;
    }
}
