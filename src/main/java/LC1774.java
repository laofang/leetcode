/**
 * Leetcode1774题，最接近目标价格的甜点成本
 * 关键字：数组、动态规划、回溯
 * 主要思路：
 * 1. 回溯 + 剪枝
 * 2. 对每个配料尝试加0~2份，然后计算价格，再加下一份，进行回溯
 * 3. 如果当前价格 == target，那可以终止回溯，答案就是target
 * 4. 当abs(target - 当前价格) <= abs(target - 当前价格)，此时可能需要更新res；反之且当前价格 > res，停止当前回溯
 */
public class LC1774 {
    int res = 30000;
    boolean end = false;
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        for(int base : baseCosts) {
            backTrack(toppingCosts,0, base, target);
            if(end) break;
        }
        return res;
    }
    public void backTrack(int[] tc, int i, int value, final int target) {
        int cur = Math.abs(value - target);
        int pre = Math.abs(res - target);
        if(cur > pre && value > res) return;
        if(cur <= pre) {
            if(cur < pre) res = value;
            else if(value < res) res = value;
        }
        if(end || i >= tc.length) return;
        if(value == target) {
            res = value;
            end = true;
            return;
        }

        for(int j = 0; j < 3; j++) {
            value += j * tc[i];
            backTrack(tc, i + 1, value,  target);
            if(end) return;
            value -= j * tc[i];
        }
    }
}
