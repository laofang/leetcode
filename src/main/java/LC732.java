import java.util.TreeMap;

/**
 * Leetcode732题，我的日程安排表III
 * 关键字：设计、线段树、有序集合
 * 主要思路：
 * 1. 使用差分法来做
 * 2. map.get(start) + 1, map(end) - 1;
 * 3. 最后结果按key升序进行相加，求相加过程中的最大值
 */
public class LC732 {
    private TreeMap<Integer,Integer> map;
    public LC732() {
        map = new TreeMap<>();
    }

    public int book(int start, int end) {
        int ans = 0;
        int maxBook = 0;
        map.put(start,map.getOrDefault(start,0) + 1);
        map.put(end,map.getOrDefault(end,0) - 1);
        for(Integer key : map.keySet()) {
            int value = map.get(key);
            maxBook += value;
            ans = Math.max(maxBook,ans);
        }
        return ans;
    }
    //TODO，差分法时间复杂度O(2n)，考虑使用线段树进行优化
}
