import java.util.LinkedList;

/**
 * Leetcode42题，接雨水
 * 关键字：数组、动态规划、双指针，单调栈
 * 主要思路：
 * i位置水量，取决于i左侧最大值和右侧最大值中较小的一个决定，这个值再减去height[i]即使，i位置的蓄水量
 * 1. 动态规划
 *      1. 两个一维数组，分别存在i位置时，i左侧最大(包括i)为leftMax[i],i右侧最大为rightMax[i](包括i)
 *      2. 分别从左到右，从右向左遍历，得到dp数组
 *      3. Math.min(leftMax[i],rightMax[i]) - height[i]即可
 * 2. 单调栈
 *      1. 一个单调栈，入的高度小于栈顶，则入栈位置i
 *      2. 假设栈顶为top，栈顶的下一个为left，如果大于栈顶。top出栈，min(height[i],heigt[left])-height[top]为高，宽度为i-left-1
 *      3. 然后left作为top，再重复2这个过程，直到栈空，或height[top] > height[i]结束，i入栈
 * 3. 双指针
 *      1. 左右各一个指针，同时还有leftMax和rightMax变量
 *      2. 如果leftMax和rightMax更小的那一侧移动
 *      3. 如果height[i] > max,更新max变量
 *      4. 当前height[i]<= max,则计算蓄水量 max-height[i]
 *      5. 重复上述过程，直到两指针相等
 */
public class LC42 {
    //动态规划
    public int trap(int[] height) {
        //dp数组
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        leftMax[0] = height[0];
        rightMax[height.length-1] = height[height.length - 1];
        int res = 0;
        //左侧dp数组
        for(int i = 1; i < height.length;i++) {
            leftMax[i] = Math.max(leftMax[i-1],height[i]);
        }
        //右侧dp数组
        for(int i = height.length - 2;i >= 0;i--) {
            rightMax[i] = Math.max(rightMax[i+1],height[i]);
        }
        //i的位置蓄水量 = min(leftMax[i],rightMax[i]) - height[i];
        for (int i = 0; i < height.length; i++) {
            int curH = Math.min(leftMax[i],rightMax[i]);
            res += (curH - height[i]);
        }
        return res;
    }
    //单调栈
    public int trap1(int[] height) {
        //定义单调栈，存索引
        LinkedList<Integer> indexs = new LinkedList<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            //如果栈不空且栈顶小于当前高度，则重复这个过程
            while (indexs.size() != 0 && height[indexs.getFirst()] < height[i]) {
                //移除栈顶
                int top = indexs.removeFirst();
                //如果移除栈顶后不为空
                if (indexs.size() != 0) {
                    //当前栈顶即是left
                    int left = indexs.getFirst();
                    //宽度为i-left-1,高度是min(height[left],height[i])-height[top],相乘即为蓄水量
                    res += (i - left - 1) * (Math.min(height[left], height[i]) - height[top]);
//                        System.out.println((i - left - 1) + " " + (Math.min(height[left], height[i]) - height[top]) + " " + res);
                }
            }
            indexs.addFirst(i);
        }
        return res;
    }
    //双指针
    public int trap3(int[] height) {
        //左最大为leftMax
        int leftMax = height[0];
        //右最大为rightMax
        int rightMax = height[height.length-1];
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int res = 0;
        //直到左右索引相等位置
        while(leftIndex < rightIndex) {
            //小的一侧向另一个方向移动，同时计算储水量，更新新的最大值
            if(leftMax < rightMax) {
                leftIndex++;
                if(height[leftIndex] <= leftMax) {
                    res += (leftMax - height[leftIndex]);
                } else {
                    leftMax = height[leftIndex];
                }

            } else {
                rightIndex--;
                if(height[rightIndex] <= rightMax) {
                    res += (rightMax - height[rightIndex]);
                } else {
                    rightMax = height[rightIndex];
                }
            }
        }
        return res;
    }
}
