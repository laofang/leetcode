import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode1234题，替换子串得到平衡字符串
 * 关键字：字符串、滑动窗口
 * 主要思路：
 * 1. 滑动窗口，替换子串外的每个字符数量不大于 len(s) / 4，就可以替换
 * 2. 移动窗口，找到最小的长度的这样的子串
 */
public class LC1234 {
    public int balancedString(String s) {
        char[] chs = s.toCharArray();
        int ans = chs.length;
        Map<Character,Integer> map = new HashMap<>();
        for(char ch : chs) {
            int cnt = map.getOrDefault(ch,0);
            map.put(ch,++cnt);
        }
        int v = chs.length / 4;
        if(map.getOrDefault('Q',0) == v && map.getOrDefault('W',0) == v &&
                map.getOrDefault('E',0) == v && map.getOrDefault('R',0) == v)
            return 0;

        int l = 0;
        for(int r = 0; r < chs.length; r++) {
            int cnt = map.getOrDefault(chs[r],0);
            map.put(chs[r],--cnt);
            while(map.getOrDefault('Q',0) <= v && map.getOrDefault('W',0) <= v &&
                    map.getOrDefault('E',0) <= v && map.getOrDefault('R',0) <= v) {
                ans = Math.min(ans,r - l + 1);
                cnt = map.getOrDefault(chs[l],0);
                map.put(chs[l++],++cnt);
            }
        }
        return ans;
    }
}
