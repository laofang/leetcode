import java.util.Deque;
import java.util.LinkedList;

/**
 * Leetcode862题，和至少为K的最短子数组
 * 关键字：队列、数组、二分查找、前缀和、滑动窗口、单调队列、堆（优先队列）
 * 主要思路：
 * 1. 前缀和与双端队列
 * 2. 先求出每个位置的前缀和
 * 3. 当前前缀和x，与队列中前面的前缀和进行对比，如果 x - sum[i] >= k，
 * 则尝试更新最小长度，同时sum[i]可以出队，因为之后的值y，即使y - sum[i] >= k，但是y的索引 - i必然大于x的索引 - i;
 * 4. 再从当前位置开始，向前看，如果sum[i] >= x，sum[i]也要出队，因为x之后的值-sum[i] >= k，则去减x也>=k同时，距离更短
 */
public class LC862 {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] sum = new long[n + 1];
        int ans = n + 1;
        for(int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        Deque<Integer> q = new LinkedList<>();
        for(int i = 0; i <= n; i++) {
            long curSum = sum[i];
            while(!q.isEmpty() && curSum - sum[q.peekFirst()] >= k) {
                ans = Math.min(ans,i - q.pollFirst());
            }
            while(!q.isEmpty() && sum[q.peekLast()] >= curSum) {
                q.pollLast();
            }
            q.addLast(i);
        }
        return ans > n ? -1 : ans;
    }
}
//todo Leetcode862.和至少为K的最短子数组，hard，用到了前缀和和双端队列，对于双端队列，可以再体会体会，效率不是特别高，还有优化空间