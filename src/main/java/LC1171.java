import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode1171题，从链表中删去总和值为零的连续节点
 * 关键字：哈希表、链表
 * 主要思路：
 * 1. 使用哈希表记录当前前缀和和对应的节点，如果当前节点的前缀和出现过，说明出现的节点（不包括）到当前节点元素序列和为0,修改指针指向即可
 * 2. 如果当前节点对应的前缀和为0，说明当前节点（包括）及其前面的元素和为0，新的头节点为当前节点的下一个节点
 * 3. 重复1，2过程，直到遍历整个序列，没有指针修改为止
 */
public class LC1171 {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode[] result = f(head);
        while(result[1].val != 1) {
            result = f(result[0]);
        }
        return result[0];
    }
    public ListNode[] f(ListNode head) {
        ListNode[] result = new ListNode[2];
        result[1] = new ListNode();
        Map<Integer,ListNode> map = new HashMap<>();
        int preSum = 0;
        ListNode p = head;
        while(p != null) {
            preSum += p.val;
            if(preSum == 0) {
                result[0] = p.next;
                result[1].val = 0;
                return result;
            } else if(map.get(preSum) != null) {
                ListNode pre = map.get(preSum);
                pre.next = p.next;
                result[0] = head;
                result[1].val = 0;
                return result;
            } else {
                map.put(preSum,p);
            }
            p = p.next;
        }
        result[0] = head;
        result[1].val = 1;
        return result;
    }
}
