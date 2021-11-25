/**
 * Leetcode458题，可怜的小猪
 * 关键字：信息熵、排列组合
 * 主要思路：
 * 1. 假设实验n轮，m只猪，每一只猪可能死在第1轮、第2轮……第n轮，或者始终没死一共(n+1)种可能
 * 2. 一共m只猪，对应每轮的状态就有(n+1)^m种可以验证至少(n+1)^m个桶
 * 3. 所以如果有k个桶，至少需要 log_(n+1) k(以n+1为底k的对数) 只猪 <= m
 */
public class LC458 {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        return (int)Math.ceil(( Math.log(buckets) / Math.log(minutesToTest / minutesToDie + 1) ));
    }
}
