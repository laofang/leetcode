/**
 * Leetcode1802题，有界数组中指定下标处的最大值
 * 关键字：贪心、二分查找
 * 主要思路：
 * 1. 采用二分法，在index处尝试[1,maxSum]之间得值，计算可能得最小和
 * 2. 最终找到一个index处的值，使得此时sum<=maxSum的sum最大
 */
public class LC1802 {
    public int maxValue(int n, int index, int maxSum) {
        int l = 1;
        int r = maxSum;
        while(l <= r) {
            int half = (l + r) / 2;
            if(getSum(half,n,index) > maxSum) {
                r = half - 1;
            } else {
                l = half + 1;
            }
        }
        return r;
    }
    public long getSum(long k, int n, int index) {
        long lCnt = index;
        long rCnt = n - index - 1;
        long lSum = 0;
        long rSum = 0;
        if(lCnt <= k - 1) {
            lSum = ((k-lCnt) + (k-1)) * lCnt / 2;
        } else {
            lSum  = (1 + (k-1)) * (k-1) / 2 + (lCnt - k + 1);
        }
        if(rCnt <= k - 1) {
            rSum = ((k-rCnt) + (k-1)) * rCnt / 2;
        } else {
            rSum  = (1 + (k-1)) * (k-1) / 2 + (rCnt - k + 1);
        }
        return lSum + rSum + k;
    }
}
