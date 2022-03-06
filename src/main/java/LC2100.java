import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode2100题，适合打劫银行的日子
 * 关键字：数组、动态规划、前缀和
 * 主要思路：
 * 1. 动态规划，lrDp[i]记录第i个元素前面有多少不小于它的元素
 * 2. 同理，rlDp[i]记录第i个元素后面右多少个不小于它的元素
 */
public class LC2100 {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        int lrDp[] = new int[n];
        int rlDp[] = new int[n];

        lrDp[0] = 0;
        for (int i = 1; i < n; i++) {
            if(security[i] <= security[i-1]) {
                lrDp[i] = lrDp[i-1]+1;
            } else {
                lrDp[i] = 0;
            }
        }

        rlDp[n-1] = 0;
        for(int i = n-2; i > 0; i--) {
            if(security[i] <= security[i+1]) {
                rlDp[i] = rlDp[i+1]+1;
            } else {
                rlDp[i] = 0;
            }
        }

        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if(lrDp[i] >= time && rlDp[i] >= time) {
                ans.add(i);
            }
        }
        return ans;
    }
}
