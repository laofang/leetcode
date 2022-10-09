import java.util.LinkedList;

/**
 * Leetcode856题，括号的分数
 * 关键字：栈和字符串
 * 主要思路：
 * 1. 用了两种方法
 * 2. 第一种方法：分治递归
 *      1. 要想算出(A)的分数，(A) = 2 * A, 这就是一个递归
 * 3. 第二种方法：栈
 *      1. 遇到左括号把0入栈
 *      2. 遇到右括号，分情况讨论
 *          1. 如果栈顶是0，出栈，如果新的栈顶是0，把1入栈，否则1进行合并后入栈
 *          2. 如果栈顶>0，出栈，如果新的栈顶是0，也出栈，然后将top*2入栈；如果新的栈顶不是0，当前栈顶出栈，top*2+当前栈顶入栈
 *      3. 最后栈顶就是答案
 */
public class LC856 {
    /**
     * 运用栈
     * @param s
     * @return
     */
    public int scoreOfParenthesesSTACK(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(0);
            } else {
                int top = stack.pop();
                if(top == 0) {
                    if(!stack.isEmpty()) {
                        if(stack.peek() != 0) {
                            int newTop = stack.pop();
                            stack.push(1 + newTop);
                        } else {
                            stack.push(1);
                        }
                    } else{
                        stack.push(1);
                    }
                } else {
                    stack.pop();
                    if(!stack.isEmpty()) {
                        int newTop = stack.peek();
                        if(newTop > 0) {
                            stack.pop();
                            stack.push(top * 2 + newTop);
                        } else {
                            stack.push(top * 2);
                        }
                    } else {
                        stack.push(top * 2);
                    }
                }
            }
        }
        return stack.peek();
    }

    /**
     * 使用分治递归方法
     * @param s
     * @return
     */
    public int scoreOfParenthesesDAC(String s) {
        if(s.equals("()")) return 1;
        int score = 0;
        int i = 0;
        while(i < s.length()) {
            int count = 0;
            int start = i;
            while(i < s.length()) {
                if(s.charAt(i) == '(') {
                    ++count;
                } else{
                    --count;
                }
                if(count == 0) {
                    if(start == i - 1) {
                        score += 1;
                    } else {
                        score += 2 * scoreOfParenthesesDAC(s.substring(start+1,i));
                    }
                    i++;
                    break;
                }
                i++;
            }
        }
        return score;
    }
}
