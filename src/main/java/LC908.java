/**
 * Leetcode908题，最小差值
 * 关键字：数组、数学
 * 主要思路：
 * 1. 给定的k值，能让本来最大差值减少多少
 * 2. 最多可让最大差值减少2k，也就是2k >= 最大差值，可以抹平差值，返回0
 * 3. 如果2k < 最大差值，那最多会让最大差值减少2k
 */
public class LC908 {
    public int smallestRangeI(int[] nums, int k) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max,num);
            min = Math.min(min,num);
        }
        int target = max - min;
        if(2 * k >= target) return 0;
        return target - 2 * k;
    }
}
