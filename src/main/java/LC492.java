/**
 * Leetcode492题，构造矩形
 * 关键字：数字
 * 主要思路：
 * 1. 宽度w肯定不大于sqrt(area)
 * 2. 如果 area % w == 0，可以求长，长一定是不小于w的
 */
public class LC492 {
    public int[] constructRectangle(int area) {
        int[] ans = new int[2];
        int n = (int)Math.sqrt(area);
        int w = 1;
        for(;w <= n; w++) {
            if(area % w == 0) {
                int l = area / w;
                ans[0] = l;
                ans[1] = w;
            }
        }
        return ans;
    }
}
