import java.util.TreeMap;

/**
 * Leetcode2055题，蜡烛之间的盘子
 * 关键字：数组、字符串、二分查找、前缀和
 * 主要思路：
 * 1. 使用TreeMap记录每个蜡烛之前的盘子数目
 * 2. 然后使用给定的位置范围内的两根蜡烛之间的差，求出蜡烛之间的盘子数
 */
public class LC2055 {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '*') {
                count++;
            } else {
                map.put(i,count);
            }
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            Integer leftKey = map.ceilingKey(queries[i][0]);
            Integer rightKey = map.floorKey(queries[i][1]);
            if(leftKey == null || rightKey == null  || leftKey >= rightKey) {
                ans[i] = 0;
            } else {
                ans[i] = map.get(rightKey) - map.get(leftKey);
            }
        }
        return ans;
    }
}
