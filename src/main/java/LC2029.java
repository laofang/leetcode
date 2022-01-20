/**
 * Leetcode2029题，石子游戏IX
 * 关键字：贪心、数组、数学、博弈、计算
 * 主要思路：
 * 1. 统计余0，余1，余2的个数
 * 2. 0的个数为偶数时，相当于没有0，这个时候如果余1 > 1 && 余2 > 1，先手必赢（先拿小的，逼后手拿完少的）
 * 3. 其他情况就看余1 与 余2的个数差大于2的时候，先手赢
 *
 */
public class LC2029 {
    public boolean stoneGameIX(int[] stones) {
        int[] log = new int[3];
        for (int stone : stones) {
            log[stone % 3]++;
        }
        int target = log[0] % 2;
        //偶数个0的情况，余1，余2的数量都大于1，则先手必赢
        if (log[0] % 2 == 0) {
            return log[1] >= 1 && log[2] >= 1;
        }
        //1或2比另一个多两个以上，也是先手会赢
        return log[1] - log[2] > 2 || log[2] - log[1] > 2;
    }
}
