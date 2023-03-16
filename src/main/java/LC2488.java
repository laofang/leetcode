import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode2488题，统计中位数为K的子数组
 * 关键字：数组、哈希表、前缀和
 * 主要思路：
 * 1. 根据题意，第一步应找到K的位置，记作idx
 * 2. 设小于K的值记作-1，大于K的值记作1，等于K的值记作0
 * 3. ldp[i]为[i,idx]所有元素转化后的和，同时将[idx+1,length-1]，每个位置求前缀和，将前缀和出现按的次数记录在hash表
 * 4. 遍历ldp，找到hash中对应的key，即k满足ldp[i] + key == 1 或 == 0， 进行数量统计
 * 5. 注意，ldp[i] == 1 或 0时，[i,idx]这个数组也是满足条件的，要统计到结果中
 */

public class LC2488 {
    public int countSubarrays(int[] nums, int k) {
        int idx = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == k) {
                idx = i;
                break;
            }
        }
        int[] ldp = new int[idx + 1];
        int target = 0;
        for(int i = idx; i >= 0; i--) {
            int val = Integer.valueOf(nums[i]).compareTo(k);
            target += val;
            ldp[i] = target;
        }
        target = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = idx + 1; i < nums.length; i++) {
            int val = Integer.valueOf(nums[i]).compareTo(k);
            target += val;
            int cnt = map.getOrDefault(target,0);
            cnt++;
            map.put(target,cnt);
        }
        int ans = 0;
        for(int i = 0; i <= idx; i++) {
            int cnt1 = map.getOrDefault(-ldp[i],0);
            int cnt2 = map.getOrDefault(-ldp[i]+1,0);
            int v = ldp[i] == 0 || ldp[i] == 1 ? 1 : 0;
            ans += cnt1 + cnt2 + v;
        }
        return ans;
    }
}
