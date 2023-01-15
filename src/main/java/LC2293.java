/**
 * Leetcode2293题，极大极小游戏
 * 关键字：数组、模拟
 * 主要思路：
 * 1. 这道题按模拟写就可以，但是写起来稍微有那么一点儿麻烦，所以我选择递归
 * 2. 递归也可以看作是一个模拟，一切两半，左侧求下一阶段两半中的最小，右侧求下一阶段两半中的最大，当前是求什么，由标志位（一个参数）决定
 */
public class LC2293 {
    public int minMaxGame(int[] nums) {
        if(nums.length == 1) return nums[0];
        return f(0,nums.length,true,nums);
    }
    public int f(int cur,int len,boolean min,int[] nums) {
        if(len == 2) {
            if(cur / 2 % 2 == 0) {
                return Math.min(nums[cur],nums[cur+1]);
            } else {
                return Math.max(nums[cur],nums[cur+1]);
            }
        } else {
            //如果是求左部分和右部分两个值的最小值
            if(min) {
                return Math.min(f(cur,len/2,true,nums),
                        f(cur + len / 2, len/2,false,nums));
                //如果是求左部分和右部分两个值的最大值
            } else {
                return Math.max(f(cur,len/2,true,nums),
                        f(cur + len / 2, len/2,false,nums));
            }
        }
    }
}
