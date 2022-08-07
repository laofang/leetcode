import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode636题，函数独占时间
 * 关键字：栈、数组
 * 主要思路：
 * 1. 使用栈来模拟方法调用的压栈
 * 2. 分为两种情况
 *     1. 如果是调用方法，当前距离上层方法的时间，便是上层方法执行的部分时间
 *     2. 如果是结束调用，当前距离上个结束的时间，是当前方法执行的部分时间
 */
public class LC636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        int time = 0;
        LinkedList<int[]> stack = new LinkedList<>();
        for(int i = 0; i < logs.size(); i++) {
            int[] cur = translate(logs.get(i));

            if(stack.isEmpty()) {
                stack.push(cur);
                time = cur[2];
                continue;
            }
            int[] pre = stack.peek();
            if(cur[1] == 0) {
                ans[pre[0]] += (cur[2] - time);
                stack.push(cur);
                time = cur[2];
            } else {
                ans[pre[0]] += (cur[2] - time + 1);
                stack.pop();
                time = cur[2] + 1;
            }


        }
        return ans;
    }
    public int[] translate(String s) {
        int[] result = new int[3];
        String[] strs = s.split(":");
        result[0] = Integer.valueOf(strs[0]);
        result[1] = strs[1].equals("start") ? 0 : 1;
        result[2] = Integer.valueOf(strs[2]);
        return result;
    }
}
