import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode1431题，有最多糖果的孩子
 * 关键字：数组
 * 主要思路：
 * 1. 先求出拥有最大糖果的数量，再遍历每个孩子加上最大数量，如果大于等于已知最大数量就为true
 */
public class LC1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for(int i = 0; i < candies.length; i++) {
            max = Math.max(candies[i],max);
        }
        List<Boolean> list= new ArrayList<>();
        for(int i = 0; i < candies.length; i++) {
            if(candies[i] + extraCandies >= max) list.add(true);
            else list.add(false);
        }
        return list;
    }
}
