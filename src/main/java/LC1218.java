import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode1218题，最长定差子序列
 * 关键字：数组
 * 主要思路：
 * 1. 遍历数组，每个当前数字为arr[i],根据前一个有效数字的计数 + 1，再将(arr[i],count+1)记录到map
 * 2. 每次进行最大值的比较，只要arr遍历一遍，即可获得结果
 */
public class LC1218 {
    public int longestSubsequence(int[] arr, int difference) {
        //记录每一个数字，作为有效数字是第几个
        Map<Integer,Integer> m = new HashMap<>();
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            //是否有前一个有效数字
            int count = m.getOrDefault(arr[i] - difference,0);
            //将前一个有效数字的序数+1,即使当前数字的序数
            max = Math.max(max,count+1);
            m.put(arr[i],count+1);
        }
        return max;
    }
}
