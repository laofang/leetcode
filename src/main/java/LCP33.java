import java.util.Arrays;

/**
 * LCP33题，蓄水
 * 关键字：贪心、数组、堆（优先队列）
 * 主要思路：
 * 1. 假设倒k次，全部满足，就可以求出每个桶要升级多少次
 * 2. 对k进行遍历，找到k+升级次数最少的一种情况
 */
public class LCP33 {
    public int storeWater(int[] bucket, int[] vat) {
        int n = vat.length;
        int kMax = Arrays.stream(vat).max().getAsInt();
        int ans = Integer.MAX_VALUE;
        if(kMax == 0) return 0;
        for(int k = 1; k <= kMax && k < ans; k++) {
            int cur = 0;
            for(int i = 0; i < n; i++) {
                cur += Math.max((vat[i] + k - 1) / k - bucket[i] , 0);
            }
            ans = Math.min(cur + k,ans);
        }
        return ans;
    }
}
