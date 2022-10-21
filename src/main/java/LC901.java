import java.util.LinkedList;

/**
 * Leetcode901题，股票价格跨度
 * 关键字：栈、设计、数据流、单调栈
 * 主要思路：
 * 1. 使用单调栈，每个栈元素包含price和对应跨度。
 * 2. 入栈时，如果栈空，直接入栈
 * 3. 如果栈不空，当前price大于栈顶的price，则循环出栈并累计跨度，直到栈空或栈顶元素的price大于当前的price
 */
public class LC901 {
    LinkedList<int[]> stack;
    public LC901() {
        stack = new LinkedList<int[]>();
    }

    public int next(int price) {
        if(stack.isEmpty()) {
            stack.push(new int[]{price,1});
            return 1;
        }
        int cnt = 0;
        while(!stack.isEmpty() && stack.peek()[0] <= price) {
            int[] peek = stack.pop();
            cnt += peek[1];
        }
        cnt++;
        stack.push(new int[]{price,cnt});
        return cnt;
    }
}
