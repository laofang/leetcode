import java.util.HashMap;
import java.util.Map;
/**
 * Leetcode5900题，蜡烛之间的盘子
 * 关键字：TreeMap、数组
 * 主要思路：
 * 1. 比赛时想到的方法超时，最后比赛结束才写出来
 * 2. 遍历，记录0索引到每一个蜡烛时有效的盘子数（指在两个蜡烛之间的盘子）
 * 3. 记录每个蜡烛的下一个蜡烛索引
 * 4. 记录当前索引的前一个蜡烛
 * 5. 再对给定的位置进行遍历
 *      1. 找到左侧的下一个蜡烛，和右侧的前一个蜡烛
 *      2. 左侧的蜡烛，要找前一个的后一个
 *      3. 然后直到第一个蜡烛，到每一个蜡烛中间的有效盘子数，做差即可
 */
public class LC5900 {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[] ans = new int[queries.length];
        //0到某蜡烛有效的盘子数
        Map<Integer,Integer> dpCount = new HashMap<>();

        //某蜡烛的下一个蜡烛的索引
        Map<Integer,Integer> dpNextP = new HashMap<>();

        //盘子的前一个蜡烛，如果当前是蜡烛，则返回当前位置
        int[] dpPr = new int[s.length()];


        //第一个蜡烛
        int firstP = -1;
        //前一个蜡烛
        int prP = -1;

        int pCount = 0;
        for(int i = 0; i < s.length(); i++) {

            if(s.charAt(i) == '|') {
                pCount++;
                if(firstP == -1) {
                    firstP = i;
                    dpCount.put(i,0);
                } else {
                    dpCount.put(i,i-firstP - pCount + 1);
                }
                dpNextP.put(prP,i);
                prP = i;
            }
            dpPr[i] = prP;
        }

        for(int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            start = start == dpPr[start] ? start: dpNextP.get(dpPr[start]);
            // System.out.println(start + " " + end + " front " + dpPr[end] );


            end = dpPr[end];

            // System.out.println(start + " " + end);

            if(start >= end ) continue;

            ans[i] = dpCount.get(end) - dpCount.get(start);
        }

        return ans;

    }
    //todo LC5900，蜡烛中间的盘子，可以用TreeMap来优化
}
