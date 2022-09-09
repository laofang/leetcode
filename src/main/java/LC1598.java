/**
 * Leetcode1598题，文件夹操作日志搜集器
 * 关键字：栈、数组、字符串
 * 主要思路：
 * 1. 关注字符串的前两个字符
 * 2. 如果是"..“，且当前不是根目录，就减少一层
 * 3. 如果第一个字符不是"."，说明有进入了当前文件夹的下一个文件夹，则增加一层
 */
public class LC1598 {
    public int minOperations(String[] logs) {
        int cnt = 0;
        for(int i = 0;i < logs.length; i++) {
            char ch1 = logs[i].charAt(0);
            char ch2 = logs[i].charAt(1);
            if(ch1 == '.' && ch2 == '.') cnt = cnt > 0 ? --cnt : 0;
            else if(ch1 != '.') cnt++;
        }
        return cnt;
    }
}
