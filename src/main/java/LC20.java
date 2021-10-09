import java.util.Stack;

/**
 * Leetcode第二十题，有效的括号
 * 一个栈的结构就可以解决，与栈顶元素不等则入栈，否则出栈
 * 注意事项：
 * 1. 有效的括号，右括号入栈一定会匹配，不匹配说明整体无效，可以直接返回false；
 */
public class LC20 {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack();
        for (int i = 0; i < chars.length; i++) {
            if(stack.size() == 0 || stack.lastElement() != getChar(chars[i])) {
                //加了这句，效率上升，正常情况右括号不能入栈，入栈则括号无效
                if(chars[i] == ')' || chars[i] == ']' || chars[i] == '}') return false;
                stack.push(chars[i]);
            }
            else {
                stack.pop();
            }
        }
        return stack.empty();
    }

    public char getChar(char ch) {
        switch (ch) {
            case ')':
                return '(';
            case ']':
                return '[';
            case '}' :
                return '{';
            default:
                return 'x';
        }
    }
}
