/**
 * Leetcode921题，使阔奥有效的最少添加
 * 关键字：栈、贪心、字符串
 * 主要思路：
 * 1. 使用栈，进行括号匹配，剩余的数量就是需要进行添加匹配的数量
 */
public class LC921 {
    public int minAddToMakeValid(String s) {
        char[] stack = new char[1000];
        int k = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(' || k == 0) {
                stack[k] = ch;
                k++;
            } else {
                if(stack[k-1] == '(') {
                    k--;
                } else {
                    stack[k] = ch;
                    k++;
                }
            }
        }
        return k;
    }
}
