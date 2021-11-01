/**
 * Leetcode2058题，找出临界点之间的最小和最大距离
 * 关键字：列表
 * 主要思路：
 * 1. 遍历，第一个临界点和每个临界点都进行记录位置
 * 2. 两个相邻的临近点的距离，可能是最小的，边遍历边更新
 * 3. 最大的临界点距离就是第一个和最后一个
 */
public class LC2058 {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode pre = head;
        ListNode cur = head;
        //当前从第二个节点开始
        if(cur.next != null) {
            cur = cur.next;
        }

        //不存在临界点
        int[] ans = new int[]{-1,-1};
        int min = Integer.MAX_VALUE;
        int first = 0;;
        int preN = 0;
        int count = 0;
        while(cur.next != null) {
            count++;
            // System.out.println(pre.val + " " + cur.val + " " + cur.next.val);
            //当前节点的值大于前一个和后一个，或者小于前一个或后一个，都是临界点
            if(cur.val > pre.val && cur.val > cur.next.val || cur.val < pre.val && cur.val < cur.next.val) {
                //第一个临界点的位置
                if(first == 0) {
                    first = count;
                } else {
                    //更新最小的临界点距离
                    min = Math.min(min,count - preN);
                }
                //更新前一个临界点的距离
                preN = count;
            }
            //继续遍历
            pre = cur;
            cur = cur.next;
        }
        // System.out.println(first + " " + preN);
        ans[0] = min == Integer.MAX_VALUE ? -1 : min;
        //是否存在两个临界点
        if(preN != first && preN != 0 && first != 0) {
            //preN是最后一个，最后一个和第一个做差即是最大距离答案
            ans[1] = preN - first;
        }
        return ans;
    }
}
