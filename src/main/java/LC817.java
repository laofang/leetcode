import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode817题，链表组件
 * 关键字：数组、哈希表、链表
 * 主要思路：
 * 1. 连续两次理解题意出错，浪费很多时间
 * 2. 只要找到，nums[i]里有多少个组件头就能求出答案
 * 3. 组件头的特点：
 *      1. 是链表的第一个节点
 *      2. 当前链表值的在nums种，但当前节点的前一个节点的值不在nums种，当前链表值就是组件头
 */
public class LC817 {
    public int numComponents(ListNode head, int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        ListNode q = head;
        ListNode p = q.next;
        int ans = 0;
        while(q != null) {
            p = q.next;
            if(p == null) break;
            if(map.get(p.val) != null && map.get(q.val) == null) ++ans;
            q = p;
            p = p.next;
        }
        if(map.get(head.val) != null) ++ans;
        return ans;
    }
}
