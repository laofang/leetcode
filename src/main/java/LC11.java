/**
 * Leetcode第十一题，盛最多水的容器
 * 双指针贪心算法
 * 用时：4min36s
 */
public class LC11 {
    /**
     * 最开始想到的方法，时间复杂度O(n^2)，不符合要求，超时
     */
    public int maxArea1(int[] height) {
        int max = 0;
        for(int i = 0; i < height.length; i++ ){
            for(int j = i - 1; j >= 0; j --) {
                int v = (i - j) * Math.min(height[i],height[j]);
                max = Math.max(max,v);
            }
        }
        return max;
    }

    /**
     * 看了解析后的双指针方法
     * 整体思路：
     * 1. 为什么要移动较小高度那边的边界
     * 2. 假设两个高度为x,y且x<y，x与y之间的距离为t，则容积为min(x,y)*t即x*t
     *      如果移动较大的y，新的距离t'<t，新的高度h<=x,则心得容积ht'<xt,则证明移动较大一侧的容积不会再变大
     */
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;
        while (i != j) {
            int area = (j - i) * Math.min(height[i],height[j]);
            maxArea = Math.max(maxArea,area);
            if(height[i] > height[j])
                j--;
            else
                i++;
        }
        return maxArea;
    }
}
