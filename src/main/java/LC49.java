import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetcode49题，字母异位词分组
 * 关键词：字符串、哈希表
 * 主要思路：
 * 1. 统计每个字符串中字符出现的次数，然后以类似”1a3b2c"这样的字符串作为key
 * 2. 字符串对应相同的key说明是异位词，加入即可
 */
public class LC49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> m = new HashMap<>();
        //遍历字符串数组
        for (int i = 0; i < strs.length; i++) {
            StringBuilder sb = new StringBuilder();
            int[] intKey = new int[26];
            //每个字符的数量
            for (char ch : strs[i].toCharArray()) {
                intKey[ch - 'a']++;
            }
            //根据每个字符的数量生成key
            for (int j = 0; j < intKey.length; j++) {
                if(intKey[j] != 0) {
                    sb.append(intKey[j]);
                    sb.append(j+'a');
                }
            }
            String key = sb.toString();
            //根据key获取异位分词组
            List l = m.getOrDefault(key,new ArrayList<>());
            l.add(strs[i]);
            m.put(key,l);
        }
        return new ArrayList<>(m.values());
    }
}
