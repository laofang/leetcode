import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode846题，一手顺子
 * 关键字：数组、哈希、排序
 * 主要思路：
 * 1. 先排序
 * 2. 两个hashmap，一个记录每个数字出现的次数，另一个记录当前已失效，但还未遍历的数字
 * 3. 遍历每一个数字，如果失效跳过，如果未失效，就查找当前数字和之后的连续数字是否足够
 **/
public class LC846 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer,Integer> mapCount = new HashMap<>();
        Map<Integer,Integer> mapJump = new HashMap<>();
        //统计每个数字出现的次数
        for(int i : hand) {
            int count = mapCount.getOrDefault(i,0);
            mapCount.put(i,++count);
        }
        Arrays.sort(hand);
        //遍历
        for(int i = 0; i < hand.length;i++) {
            //当前数字是否是失效的
            int count = mapJump.getOrDefault(hand[i],0);
            //如果是失效的，跳过
            if(count > 0) {
                mapJump.put(hand[i],--count);
                continue;
            }
            //当前组的数字数量每个减1
            for(int k = 0; k < groupSize;k++) {
                count = mapCount.getOrDefault(hand[i] + k,0);
                if(count == 0) {
                    return false;
                }
                //除当前数字外，其余数字要记录失效
                if(k != 0) {
                    count = mapJump.getOrDefault(hand[i] + k,0);
                    mapJump.put(hand[i]+k,++count);
                }
            }

        }

        return true;
    }
}
