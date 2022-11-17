import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetcode792题，匹配子序列的单词数
 * 关键字：字典树、哈希表、字符串、排序
 * 主要思路：
 * 1. 用哈希表拉链法，对s字符串的每个字符建桶，每个桶后的元素都是该字符的下标，按顺序排序
 * 2. 对words进行遍历，测试每个字符串是否是s的子串，也就是word的每个字符在s中的下标，都要大于前一个字符在s中的下标
 * 3. 记录前一个字符在s中的下标，然后得到相对应的哈希桶，对桶后的列表进行二分查找，找到大于前一个字符在s中下标的最小的那个，再进行更新
 */
public class LC792 {
    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, List<Integer>> map = new HashMap<>(26);
        for (int i = 0; i < s.length(); i++) {
            List<Integer> list = map.getOrDefault(s.charAt(i),new ArrayList<>());
            list.add(i);
            map.put(s.charAt(i),list);
        }
        int cnt = 0;
        for(String word : words) {
            int preIndex = -1;
            char[] chs = word.toCharArray();
            int i = 0;
            int[] log = new int[26];
            for(i = 0; i < chs.length; i++) {
                List<Integer> list = map.get(chs[i]);
                int v = chs[i] - 'a';
                if(list == null || list.size() <= log[v]) break;
                int index = search(list,log[v],preIndex);
                if(index == -1) break;
                preIndex = list.get(index);
                log[v] = index + 1;
            }
            if(i == chs.length) cnt++;

        }
        return cnt;
    }
    public int search(List<Integer> list,int l, int target) {
        int left = l;
        int right = list.size() - 1;
        while(left <= right) {
            int half = (left + right) / 2;
            int index = list.get(half);
            if(index <= target) left = half + 1;
            else right = half - 1;
        }
        return  left >= list.size() ? -1 : left;
    }
}
