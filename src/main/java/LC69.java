/**
 * Leetcode69题，Sqrt(x)
 * 关键字：二分法
 * 主要思路：
 * 1. Integer.MAX_VALUE 的开方 是46340，所以最大可能值就是46340
 * 2. 然后二分在1与46340之间，如果x更小，可以从1到x之间二分
 * 3. 这个二分是求 平方小于等于x中最大的那个
 */
public class LC69 {
    public int mySqrt(int x) {
        if(x == 0) {
            return 0;
        }
        if(x > 46340*46340) {
            return 46340;
        }

        int r = x > 46340? 46340:x;
        int l = 1;
        while(l <= r) {
            int half = (l + r) / 2;
            int mul = half * half;
            //l最终会 l * l > x的值，（如果存在大于x的值),l的左侧是<=x的最大值
            if(mul <= x) {
                l = half + 1;
            } else {
                r = half - 1;
            }
//            System.out.println(l + " " +r);
        }
        return r;
    }
}
