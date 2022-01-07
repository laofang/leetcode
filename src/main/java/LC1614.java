import java.util.LinkedList;

/**
 * Leetcode1614题，括号的最大嵌套深度
 * 关键字：栈、字符串
 * 主要思路：
 * 1. 只需要一个栈，遇到'('入栈，遇到')'出栈，每次操作后，栈中深度与答案对比，保留大的即可
 */
public class LC1614 {
    public int maxDepth(String s) {
        //栈
        LinkedList<Character> list = new LinkedList<>();
        int ans = 0;
        for(int i = 0; i < s.length();i++) {
            char ch = s.charAt(i);
            //'('入栈
            if(ch == '(') {
                list.push(ch);
                //’)'出栈
            } else if(ch == ')') {
                list.pop();
            }
            ans = Math.max(list.size(),ans);
        }
        return ans;
    }
}
