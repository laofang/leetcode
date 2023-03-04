/**
 * Leetcode982题，按位与为零的三元组
 * 关键字：位运算、数学、字符串
 * 主要思路：
 * 1. 先算出三元组的前两个值与运算，结果一定在2的16次方之内，所以用一个这么大的数组存储结果
 * 2. 最后再用这个结果数组，和三元组最后一位进行与操作
 */
public class LC982 {
    public int countTriplets(int[] nums) {
        int[] cnt = new int[1 << 16];
        for (int x : nums) {
            for (int y : nums) {
                ++cnt[x & y];
            }
        }
        int ans = 0;
        for (int x : nums) {
            for (int mask = 0; mask < (1 << 16); ++mask) {
                if ((x & mask) == 0) {
                    ans += cnt[mask];
                }
            }
        }
        return ans;
    }
}
