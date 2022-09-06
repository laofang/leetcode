import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetcode828题，统计子串中的唯一字符
 * 关键字：哈希表、字符串、动态规划
 * 主要思路：
 * 1. 记录相同字符出现的所有位置
 * 2. 计算每个字符的贡献值
 *      设当前字符c的位置为i，前一个c的位置为p，后一个c的位置为n
 *      当前字符c的贡献值为(i - p) * (n - i)
 */
public class LC828 {
    Map<Character, List<Integer>> map = new HashMap<>();
    public int uniqueLetterString(String s) {
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(!map.containsKey(ch)) {
                map.put(ch,new ArrayList<>());
                map.get(ch).add(-1);
            }
            map.get(ch).add(i);
        }
        int ans = 0;
        for(Map.Entry entry : map.entrySet()) {
            List<Integer> list = map.get(entry.getKey());
            list.add(s.length());
            for(int i = 1; i < list.size() - 1; i++) {
                ans += (list.get(i) - list.get(i-1)) * (list.get(i+1) - list.get(i));
            }
        }
        return ans;
    }
}
