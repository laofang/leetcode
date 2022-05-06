/**
 * Leetcode933题，最近的请求次数
 * 关键字：设计、队列、数据流
 * 主要思路：
 * 1. 每次ping，都用数组来记录此时的时间和当前的长度
 * 2. 从left位置进行循环，如果nums[left] < t - 3000,left++
 * 3. right - left就是最终答案
 */

public class LC933 {
    int[] nums;
    int left;
    int right;
    public LC933() {
        left = 0;
        right = 0;
        nums = new int[100000];
    }

    public int ping(int t) {
//        map.put(t,++count);
//        int preCount = map.get(map.ceilingKey(t-3000));
//        return count - preCount + 1;
        nums[right++] = t;
        while(t-3000 > nums[left]) {
            left++;
        }
        return right - left;
    }
}
