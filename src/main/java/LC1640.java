import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode1640题，能否连接形成数组
 * 关键字：数组、哈希表
 * 主要思路：
 * 1. 记录pieces中的每个数组，每个数组的第一个元素为键，数组为值
 * 2. arr进行匹配，从第一个元素开始作为键，获取对应数组，比较同时下标后移，重复这个过程
 */
public class LC1640 {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer,int[]> map = new HashMap<>();
        for(int i = 0; i < pieces.length; i++) {
            map.put(pieces[i][0],pieces[i]);
        }
        int i = 0;
        while(i < arr.length) {
            int[] nums = map.get(arr[i]);
            if(nums == null) return false;
            int j = 0;
            while(i < arr.length && j < nums.length && arr[i] == nums[j]) {
                i++;
                j++;
            }
            if(j != nums.length) return false;
        }
        return true;
    }
}
