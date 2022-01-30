import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode884题，两句话中的不常见单词
 * 关键字：字符串、哈希
 * 主要思路：
 * 1. 两个哈希，分别记录两个句子中的每个单词出现的次数
 * 2. 再次遍历两个字符串数组
 * 3. 在当前数组中出现一次，在另一字符串数组中未出现过，记录到list中
 */
public class LC884 {
    public String[] uncommonFromSentences(String s1, String s2) {
        ArrayList<String> res = new ArrayList<>();
        Map<String,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        String[] s1s = s1.split(" ");
        String[] s2s = s2.split(" ");
        for (String s : s1s) {
            Integer count = map1.getOrDefault(s,0);
            map1.put(s,++count);
        }
        for (String s : s2s) {
            Integer count = map2.getOrDefault(s,0);
            map2.put(s,++count);
        }
        for (String s : s1s) {
            if(map1.getOrDefault(s,0) == 1 && map2.getOrDefault(s,0) == 0) {
                res.add(s);
            }
        }
        for (String s : s2s) {
            if(map2.getOrDefault(s,0) == 1 && map1.getOrDefault(s,0) == 0) {
                res.add(s);
            }
        }
        String[] ans = new String[res.size()];
        res.toArray(ans);
        return ans;

    }
}
