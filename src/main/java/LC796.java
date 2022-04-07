/**
 * Leetcode796题，旋转字符串
 * 关键字：字符串、字符串匹配
 * 主要思路：
 * 1. 遍历s中每个字符，如果当前字符与goal第一个字符相等，就又可能旋转后相等
 * 2. 进行旋转就是(i,s.length()) + (0,i)，判单旋转后是否和goal相等
 */
public class LC796 {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        for(int i = 0; i < s.length();i++) {
            if(s.charAt(i) == goal.charAt(0)) {
                if( (s.substring(i) + s.substring(0,i)).equals(goal)) return true;
            }
        }
        return false;
    }
}
