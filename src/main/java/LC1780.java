/**
 * Leetcode1780题，判断一个数字是否可以表示成三的幂的和
 * 关键字：数学
 * 主要思路：
 * 1. 可以类比二进制转换十进制，同理，如果一个十进制数，在三进制下，每一位都是1或0就是符合题意的，如果出现2，那说明那一位有多个相同3的幂出现
 */
public class LC1780 {
    public boolean checkPowersOfThree(int n) {
        while(n > 0) {
            if(n % 3 > 1) return false;
            n /= 3;
        }
        return true;
    }
}
