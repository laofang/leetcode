/**
 * Leetcode1678题，设计Goal解析器
 * 关键字：字符串
 * 主要思路：
 * 1. 简单模拟，字符串拼接
 */
public class LC1678 {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < command.length()) {
            char ch = command.charAt(i);
            if(ch == 'G') {
                sb.append('G');
                i++;
            } else if(command.charAt(i+1) != ')') {
                sb.append("al");
                i+=4;
            } else {
                sb.append("o");
                i += 2;
            }
        }
        return sb.toString();
    }
}
