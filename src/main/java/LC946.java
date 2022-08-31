import java.util.LinkedList;

/**
 * Leetcode946题，验证栈队列
 * 关键字：栈、数组、模拟
 * 主要思路：
 * 1. 栈顶元素如果和出栈元素不一致，就一直入栈，直到栈顶和当前出栈元素相同
 * 2. 栈顶元素如果和当前出栈元素一致，则一直尝试出栈，直到栈顶元素和当前出栈元素不同
 * 3. 最后判断两个数组的指针是否都在末尾
 */
public class LC946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> stack = new LinkedList<>();
        int pu = 0;
        int po = 0;
        while(pu < pushed.length && po < popped.length) {
            while(pu < pushed.length && (stack.isEmpty() || stack.peek() != popped[po])) {
                stack.push(pushed[pu]);
                pu++;
            }
            while(po < pushed.length && !stack.isEmpty() && stack.peek() == popped[po]) {
                stack.pop();
                po++;
            }
        }
        return pu == pushed.length && po == popped.length;
    }
}
