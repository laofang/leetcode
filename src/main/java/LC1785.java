/**
 * Leetcode1785题，构成特定和需要添加的最少元素
 * 关键字：贪心、数组
 * 主要思路：
 * 1. 得到nums的和与goal的差值的绝对值，然后可能这绝对值里有多少个limit，向上取整
 * 2. 简单题水平，不应该中等题
 * 3. 小技巧，对k / m向上取整，可以 (k + m - 1) / m
 */
public class LC1785 {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for(int num : nums) {
            sum += num;
        }
        return (int)(((Math.abs(sum - goal) + limit - 1) / limit));
    }
}
