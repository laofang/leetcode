import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode2178题，拆分成最多数目的正偶数之和
 * 关键字：贪心、数学、回溯
 * 主要思路：
 * 1. 从2开始，逐个偶数求和，直到finalSum剩余的小于当前最大偶数
 * 2. 将剩余的finalSum + 上最后一个偶数元素作为最后一个元素
 */
public class LC2178 {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> res = new ArrayList<>();
        if (finalSum % 2 != 0) {
            return res;
        }
        for (long i = 2; i <= finalSum; i += 2) {
            res.add(i);
            finalSum -= i;
        }
        res.set(res.size() - 1, res.get(res.size() - 1) + finalSum);
        return res;
    }
}
