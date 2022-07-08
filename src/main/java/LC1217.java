/**
 * Leetcode1217题，玩筹码
 * 关键字：贪心、数组、数学
 * 主要思路：
 * 1. 从奇数位置到偶数位置，每个筹码+1；从偶数位置到奇数位置也是一样；
 * 2. 从奇数位置到奇数位置，每个筹码+0；从偶数位置到偶数位置也是一样；
 * 3. 所以是选择全部奇数位置->去一个偶数位置，还是选择全部偶数位置->去一个奇数位置，主要是看奇数和偶数位置数量。
 * 4. 所以只要返回奇数或偶数位置筹码最小的那个。
 */
public class LC1217 {
    public int minCostToMoveChips(int[] position) {
        int oddCnt = 0;
        int evenCnt = 0;
        for (int i = 0; i < position.length; i++) {
            if(position[i] % 2 == 1)
                ++oddCnt;
            else
                ++evenCnt;
        }
        return oddCnt < evenCnt ? oddCnt : evenCnt;
    }
}
