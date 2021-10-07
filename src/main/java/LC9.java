/**
 * 自己想的就是把数字反转再与原数字比较，忘记了溢出判断，然而还通过了
 * 看了解析后再此优化算法，只要反转一半与前一半相比
 * 用时：10m07s
 */
public class LC9 {
    public boolean isPalindrome(int x) {
        int y = x;
        if(y < 0) {
            return false;
        }
        int rev = 0;

        while(x > 0) {
            int digit = x % 10;
            x = x / 10;
            rev = rev * 10 + digit;
        }
        return y == rev ? true : false;
    }

    /**
     * 优化后的算法，只反转一半
     */
    public boolean isPalindrome1(int x) {
        //负数不是回文数字
        if(x < 0) {
            return false;
        }
        //如果只有一位，那么是回文数字
        if(x / 10 == 0) {
            return true;
        }
        int rev = 0;
        while(x > 0) {
            int digit = x % 10;
            x = x / 10;
            rev = rev * 10 + digit;
            //数字最后一位是0一定不是回文数字
            if(rev == 0) {
                return false;
            }
            //后半部分反转与前半部分相等，则是回文，后面是奇数情况
            if(rev == x || rev == x / 10){
                return true;
            }
        }
        return false;
    }
}
