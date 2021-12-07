import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode70题，爬楼梯
 * 关键字：动态规划、递归、记忆化搜索、经典题
 * 主要思路：
 * 1. 可以这样思考，第i阶楼梯，可以从第i-1阶楼梯走一步上去，也可以从第i-2阶楼梯走两步上去
 *      所以第i阶楼梯的走法，可以是第i-1和i-2阶楼梯走法的和，递归显而易见，也是斐波那契数列
 * 2. 动态规划的方法，dp[i] = dp[i-2] + dp[i-1]
 * 3. 也可以递归，但是递归会超时，所以可以加上记忆化搜索，也就是每阶楼梯的情况得到好进行存储，下次用的时候不用递归，直接获得
 */
public class LC70 {
    Map<Integer,Integer> map = new HashMap<>();
    public int climbStairs(int n) {
        //因为2阶楼梯有两种走法，所以0阶有一种，为了对应初始情况
        if(n == 1 || n == 0) {
            return 1;
        }
        //先看第n阶是否已经计算过
        Integer ans = map.get(n);
        //如果每计算过就递归
        if(ans == null) {
            //递归得到的结果进行记录
            ans = climbStairs(n-1) + climbStairs(n-2);
            map.put(n,ans);
        }
        return ans;

    }
}
