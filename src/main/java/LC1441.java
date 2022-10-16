import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode1441题，用栈操作构建数组
 * 关键字：栈、数组、模拟
 * 主要思路：
 * 1. 因为是单调递增，min(target) = 1, max(target) = m
 * 2. 按对比[1,m]，k是[1,m]中的元素，如果在target存在，push即可，否则，push再pop
 */
public class LC1441 {
    public List<String> buildArray(int[] target, int n) {
        final String PUSH = "Push";
        final String POP = "Pop";
        List<String> ans = new LinkedList<>();
        int[] flag = new int[n+1];
        for(int i = 0; i < target.length; i++) {
            flag[target[i]] = 1;
        }
        for(int i = 1; i <= target[target.length - 1]; i++) {
            ans.add(PUSH);
            if (flag[i] != 1) {
                ans.add(POP);
            }
        }
        return ans;
    }
}
