/**
 * Leetcode第七题，整数反转
 * 注意的地方
 * 1. 在反转的过程中可能溢出，需要判断
 */
public class LC7 {
    public int reverse(int x) {
        final int MAX_INT = (int)Math.pow(2,32)-1;
        final int MIN_INT = - (int)Math.pow(2,32);
        int rev = 0;
        while(x != 0) {
            //当出现以下两种情况，继续反转，一定会出现溢出
            if(rev < MIN_INT/10 || rev > MAX_INT/10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }
}
