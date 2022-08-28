/**
 * Leetcode793题，阶乘函数后K个零
 * 关键字：数学、二分查找
 * 主要思路：
 * 1. n!尾数0和1~n中，每个数因子5的数目有关
 * 2. 可以用二分法来找到，因子5的数目为k的最大的n
 * 3. 因子5的数目为k-1的最大n为n1
 * 4. 结果就是f(k) - f(k-1);
 */
public class LC793 {
    public int preimageSizeFZF(int k) {
        if(k < 1) return 5;
        return f(k) - f(k-1);
    }
    public int f(int x) {
        long l = 0;
        long r = (long)1e10;
        while(l <= r) {
            long half = (l + r) / 2;
            if(get5Cnt(half) <= x) {
                l = half + 1;
            } else {
                r = half -1;
            }
        }
        return (int) r;
    }

    public long get5Cnt(long a) {
        int ans = 0;
        while(a > 0) {
            ans += a / 5;
            a = a / 5;
        }
        return ans;
    }
}
