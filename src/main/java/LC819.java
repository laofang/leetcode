import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode819题，最常见单词
 * 关键字：哈希表、字符串、计数
 * 主要思路：
 * 1. 哈希表记录被禁单词
 * 2. 哈希表记录合法单词累计数量
 * 3. 遍历寻找出现次数最多，且不在被禁哈希表中的单词
 */
public class LC819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String,String> banMap = new HashMap<>();
        for (String s : banned) {
            banMap.put(s,s);
        }
        Map<String,Integer> cntMap = new HashMap<>();
        String ans = "";
        int max = 0;
        String[] strs = paragraph.split("[^\\w]\\s*");
        System.out.println(strs.length);
        for (String str : strs) {
            System.out.println(str);
        }
        for(String str : strs) {
            if(banMap.get(str.toLowerCase()) == null) {
                int count = cntMap.getOrDefault(str.toLowerCase(),0);
                cntMap.put(str.toLowerCase(),++count);
                if(count >= max) {
                    ans = str.toLowerCase();
                    max = count;
                }
            }
        }
        return ans;
    }
}
