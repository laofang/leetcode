/**
 * Leetcode709题，转换成小写字母
 * 关键字：大小写转换
 * 主要思路：
 * 1. 只要知道'A'与'a'之间的差，就知道任意一个大写字母与之对应的小写字母
 * 2. 对大写字母进行转换即可
 */
public class LC709 {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char diff = (char)('A' - 'a');
            char ch = s.charAt(i);
            if(ch - 'A' >= 0 && ch - 'Z' <= 0) {
                ch = (char)(ch - diff);
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}
