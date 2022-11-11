import java.util.Map;

/**
 * Leetcode1704题，判断字符串的两半是否相似
 * 关键字：字符串、计数
 * 主要思路：
 * 1. 前一半遇见元音字母，就累加；后一半遇见元音就累减，如果最后结果是0，前后元音数目相等
 */
public class LC1704 {
    public boolean halvesAreAlike(String s) {
        Map<Character,Integer> map = Map.of('a',1,'e',1,'i',1,'o',1,'u',1,'A',1,'E',1,'I',1,'O',1,'U',1);
        int cnt = 0;
        int n = s.length() - 1;
        for(int i = 0; i < s.length() && n - i > i; i++) {
            cnt = map.get(s.charAt(i)) != null ? ++cnt: cnt;
            cnt = map.get(s.charAt(n - i)) != null ? --cnt: cnt;
        }
        return cnt == 0;
    }
}
