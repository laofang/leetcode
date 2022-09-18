import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode1636题，按照频率将数组升序排列
 * 关键字：数组、哈希表、排序
 * 主要思路：
 * 1. 先计算出每个数字出现的频率，记录在map，再将map转化成一个二维数组
 * 2. 二维数组的每一项，是一个二元组，包括数字，及其频率
 * 3. 如果频率不等，就按频率进行排序，如果频率相等，进行二级排序，对数值本身降序排序
 * 4. 最后按顺序，以每个二元组的第二个元素也就是频率，作为次数进行遍历，将相同的值记录在待返回数组
 */
public class LC1636 {
    public int[] frequencySort(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i],0);
            map.put(nums[i],++count);
        }
        int[][] logs = new int[map.size()][2];
        int i = 0;
        for(Map.Entry<Integer,Integer> e : map.entrySet()) {
            logs[i][0] = e.getKey();
            logs[i++][1] = e.getValue();
        }
        Arrays.sort(logs,(e1, e2) -> {
            if(e1[1] != e2[1]) return e1[1] - e2[1];
            return e2[0] - e1[0];
        });
        int[] ans = new int[nums.length];
        int k = 0;
        for(i = 0; i < logs.length; i++) {
            for(int j = 0; j < logs[i][1]; j++) {
                ans[k++] = logs[i][0];
            }
        }
        return ans;
    }
}
