import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode169题，多数元素
 * 关键字：数组、哈希表、分治、计数、排序
 * 主要思路：
 * 1. map记录数字出现的次数
 * 2. 数字出现的次数 > n / 2，当前数字就是答案
 * 优化：
 * 优化了空间复杂度为O(1)
 * 1. 同归于尽的思路，当前持有一个数字，如果下一个数字和当前相同，数量增加，否则减少，0的时候换遍历中的下一个数字
 * 2. 最坏的情况，目标数字中的每一个与非目标数字抵消，那也至少会剩下一个目标数字
 * 3. 也就是按这种算法，最后目标数字的数目 >= 1，其余数字都相互抵消掉了
 */
public class LC169 {
    public int majorityElement(int[] nums) {
        int count = 0;
        int cur = 0;
        for (int num : nums) {
            if(count == 0) {
                cur = num;
                count = 1;
                continue;
            }
            if(num == cur) {
                ++count;
            } else {
                --count;
            }
        }
        return cur;
    }
}
