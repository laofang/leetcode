/**
 * Leetcode2048题，下一个更大的数值平衡数
 * 关键字：数组，hash计数
 * 主要思路：
 * 1. 用数组存储每个数字的数量，如当前数字是1，nums[1]++
 * 2. 最后遍历，如果数字出现次数不是0，且nums[i] != i，说明不是平衡数
 */
public class LC2048 {
    public int nextBeautifulNumber(int n) {
        // System.out.println(isBalanceNum(1333));
        while(true) {
            n++;
            if(isBalanceNum(n)) {
                return n;
            }
        }
    }
    public boolean isBalanceNum(int n) {
        //存储[0,9]数字出现的次数，数字k，对应t[k];
        int[] t = new int[10];
        //统计每一个数字出现的次数
        while(n > 0) {
            int temp = n % 10;
            // System.out.println(t[temp] + " " + temp);
            if(t[temp] >= temp) {
                return false;
            }
            t[temp] = t[temp] + 1;
            n /= 10;
        }
        //如果数字有出现，t[i]!=i，说明不是平衡数
        for(int i = 1; i < t.length;i++) {
            if(t[i] != 0 && t[i] != i) {
                return false;
            }
        }
        return true;
    }
}
