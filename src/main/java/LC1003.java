import java.util.LinkedList;

/**
 * Leetcode1003题，检查替换后的词是否有效
 * 关键字：栈、字符串
 * 主要思路：
 * 1. 用了两种方法，第一种是用string的replace方法，就是反复对"abc"子串进行消除，如果可以完全消除，则有效
 * 2. 用栈，一旦当前元素和栈顶元素构成"abc"就进行出栈操作
 * 3. replace比栈还快一点
 */
public class LC1003 {
    /**
     * replace方法消消乐
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        int len = s.length();
        String cur = s.replace("abc","");
        while(cur.length() != s.length()) {
            s = cur;
            cur = s.replace("abc","");
        }
        return cur.length() == 0;
    }

    /**
     * 当前遍历到的字符，和栈顶进行消消乐
     * @param s
     * @return
     */
    public boolean isValidByStack(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        char[] chs = s.toCharArray();
        int i = 0;
        while(i < chs.length) {
            if (i + 1 < chs.length && chs[i] == 'b' && chs[i + 1] == 'c') {
                if (!stack.isEmpty() && stack.peek() == 'a') {
                    stack.pop();
                    i = i + 2;
                } else {
                    stack.push(chs[i]);
                    i++;
                }
            } else if(stack.size() >= 2 && chs[i] == 'c') {
                if(stack.get(0) == 'b' && stack.get(1) == 'a') {
                    stack.pop();
                    stack.pop();
                } else {
                    stack.push(chs[i]);
                }
                i++;
            } else {
                stack.push(chs[i]);
                i++;
            }
        }
        return stack.isEmpty();
    }
}
