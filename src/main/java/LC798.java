/**
 * Leetcode798题，得分最高的最小轮调
 * 关键字：数组、前缀和、差分
 * 主要思路：
 * 1. 每个数都是在某个靠后的连续的区间内会对得分产生贡献，在某个靠左的区间内则不会产生贡献；
 * 2. 从而我们要记录分数，最高效的记录手段就是记录每次移动导致贡献与否产生变化的位置；
 * 3. 这就是差分。
 *
 */
public class LC798 {
    public int bestRotation(int[] nums) {
        int n = nums.length;

        int[] move = new int[n];

        for(int i = 0; i < n; i++) {
            if(nums[i] <= i) {
                move[0]++;
                move[(i - nums[i] + 1) % n]--;
                move[(i+1)%n]++;
            } else {
                move[(i+1) % n]++;
                move[(n - (nums[i] - i) + 1) % n]--;
            }
        }

        int score = 0;
        int maxS = 0;
        int ans = 0;

        for(int m = 0; m < n; m++) {
            score += move[m];
            if(score > maxS) {
                maxS = score;
                ans = m;
            }
        }
        return ans;
    }
}
