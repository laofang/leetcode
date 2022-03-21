/**
 * Leetcode2038题，如果相邻两个颜色均相同则删除当前颜色
 * 关键字：贪心、数学、字符串、博弈
 * 主要思路：
 * 1. 统计Alice 和 Bob分别可以操作的次数（Alice和Bob的操作不会对对方产生影响）
 * 2. 由于Alice先手，所以当Alice可操作数 > Bob可操作数时，返回true，否则false
 */
public class LC2038 {
    public boolean winnerOfGame(String colors) {
        int aCount = 0;
        int bCount = 0;
        for (int i = 1; i < colors.length() - 1; i++) {
            char ch = colors.charAt(i);
            if(ch == 'A' && colors.charAt(i-1) == 'A' && colors.charAt(i+1) == 'A') {
                ++aCount;
            }
            else if(ch == 'B' && colors.charAt(i-1) == 'B' && colors.charAt(i+1) == 'B') {
                ++bCount;
            }
        }
        return aCount > bCount;
    }
}
