import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode141题，环形链表
 * 关键字：链表
 * 主要思路：
 * 1. 记录访问过的节点，如果再次在遍历结束前，再次访问，说明有环存在
 * 2. 如果访问结束，说明无环
 */
public class LC141 {
    public boolean hasCycle(ListNode head) {
        Map<ListNode,Boolean> map = new HashMap<>();
        while(head != null) {
            if(map.get(head) != null) {
                return true;
            }
            map.put(head,true);
            head = head.next;
        }
        return false;
    }
}
