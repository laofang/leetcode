import java.util.LinkedList;

/**
 * Leetcode1047题，删除字符串中的所有相邻重复项
 * 关键字：栈、字符串
 * 主要思路：
 * 1. 采用栈，相邻消消乐
 */
public class LC1047 {
    public String removeDuplicates(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        char[] chs = s.toCharArray();
        for(int i = 0; i < chs.length; i++) {
            if(!stack.isEmpty()) {
                if(stack.peek().equals(chs[i])) {
                    stack.pop();
                } else {
                    stack.push(chs[i]);
                }
            } else {
                stack.push(chs[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : stack) {
            sb.append(ch);
        }
        return sb.reverse().toString();
    }
}
