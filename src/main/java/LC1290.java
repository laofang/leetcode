/**
 * Leetcode1290题，二进制链表转整数
 * 关键字：链表、数学
 * 主要思路：
 * 1. 按二进制转十进制算法模拟即可
 */
public class LC1290 {
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        int cnt = 0;
        ListNode p = head;
        while(p != null) {
            cnt++;
            p = p.next;
        }
        p = head;
        cnt--;
        while(p != null) {
            if(p.val != 0) {
                ans += Math.pow(2,cnt);
            }
            p = p.next;
            cnt--;
        }
        return ans;
    }
}
