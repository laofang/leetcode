/**
 * Leetcode1716题，计算力扣银行的钱
 * 关键字：数学
 * 主要思路：
 * 1. 分析前面几周和最后一周存钱的和
 */
public class LC1716 {
    public int totalMoney(int n) {
        int m = n / 7;
        int k = n % 7;
        // 前面几个完整的星期，总共存入多少
        int preWeeksAll = m * 28 + 7 * ((m-1)*m / 2);
        // 最后一个星期那几天存入多少
        int lastWeek = k * (k + 1) / 2 + m * k;
        return preWeeksAll + lastWeek;
    }
}
