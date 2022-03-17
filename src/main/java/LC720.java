import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode720题，词典中最长的单词
 * 关键字：字典树、数组、哈希表、字符串、排序
 * 主要思路：
 * 1. 先排序，首先按字符长度排序，长度相同按字典顺序排序
 * 2. 对数组数组中的字符串建立Map存储
 * 3. 然后从大到小，对每个字符串的全部前缀进行查找，如果全部存在，则说明当前的就是答案
 */
public class LC720 {
    public String longestWord(String[] words) {
        Arrays.sort(words,(e1, e2)->{
            if(e1.length() != e2.length()) {
                return e2.length() - e1.length();
            } else {
                return e1.compareTo(e2);
            }
        });
        Map<String,Integer> map = new HashMap<>(words.length);
        for (String word : words) {
            map.put(word,1);
        }
        for (String word : words) {
            int j = 1;
            for(; j < word.length(); j++) {
                int result = map.getOrDefault(word.substring(0,j),0);
                if(result == 0) break;
            }
            if(j == word.length()) return word;
        }
        return "";
    }
}
