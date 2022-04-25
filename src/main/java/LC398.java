import java.util.Random;

/**
 * Leetcode398题，随机数索引
 * 关键字：水塘抽样、哈希表、数学、随机化
 * 主要思路：
 * 1. 水塘抽样 1/i * (1 - 1 / (i+1)) * (1 - 1 / (i+2)) * ......(1 - 1/n) = 1 / n
 */
public class LC398 {
    private int[] nums;
    Random random;
    public LC398(int[] nums) {
        random = new Random();
        this.nums = nums;
    }

    public int pick(int target) {
        int cnt = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                ++cnt;
                if(random.nextInt(cnt) == 0) {
                    ans = i;
                }
            }
        }
        return ans;
    }
}
