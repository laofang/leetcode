/**
 * Leetcode29题，两数相除
 * 主要思路：
 * 1. 迭代相减，相减再迭代，就是把除法转换成减法
 * 由于负数可以表示更多的数，我们将两个操作数转为负数，结果再根据实际情况决定是正是负
 */
public class LC29 {
    public int divide(int dividend, int divisor) {
        //这个相除的结果会溢出，所以按规定返回Integer.MAX_VALUE
        if(dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        //把最小值的一半作为上限值，防止被除数相加的过程中溢出
        int Limit = Integer.MIN_VALUE>>1;
        //false为正，true为负
        boolean flag = false;
        //结果为负的情况
        if(dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) {
            flag = true;
        }
        //将操作数都转为非负数
        if(dividend > 0) dividend = -dividend;
        if(divisor > 0) divisor = -divisor;
        int res = 0;
        //也就是divisor的绝对值小于等于dividend的情况，就还能尝试继续减
        while(dividend <= divisor) {
            int d = divisor;
            //每次循环的结果
            int ans = -1;
            //这里很关键
            //临时的除数和当前答案的值如果超过limit再执行，就会溢出，所以到了此时，被除数先减，再继续迭代
            //最后还要提前尝试一下，下一次迭代是否超过被除数
            while(d > Limit && ans > Limit && d > dividend - d) {
                d+=d;
                ans+=ans;
            }
            dividend-=d;
            res +=ans;
        }
        //如果flag==true res不变，结果为负，否则就是负数的相反数
        return flag ? res : -res;
    }
}
