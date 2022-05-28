import java.util.LinkedList;

/**
 * Leetcode1021题，删除最外层的括号
 * 关键字：栈、字符串
 * 主要思路：
 * 1. 遍历字符串，遇到'('入栈，遇到')'出栈
 * 2. 一次从零入栈，到完全出栈归零，是一个完整的括号，最后出栈匹配的()就是最外层括号
 * 3. 所以当栈不空的时候，遇到'('，加入答案，如果')'匹配的时候，栈里多于一个元素，')'加入答案
 */
public class LC1021 {
    public String removeOuterParentheses(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                if(!stack.isEmpty()) {
                    ans.append('(');
                }
                stack.push('(');
            } else {
                if(stack.size() > 1) {
                    ans.append(')');
                }
                stack.pop();
            }
        }
        return ans.toString();
    }
}
