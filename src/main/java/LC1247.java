/**
 * Leetcode1247题，交换字符使得字符串相同
 * 关键字：贪心、数学、字符串
 * 主要思路：
 * 1. 统计其中一个字符串中，统计不同值的位置X的数量和Y的数量
 * 2. 'XX','YY'这种可以一次交换，'XY'和'YX'这种需要两次交换
 */
public class LC1247 {
    public int minimumSwap(String s1, String s2) {
        if (s1.length() != s2.length()) return -1;
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        int cntX = 0;
        int cntY = 0;
        for (int i = 0; i < chs1.length; i++) {
            if (chs1[i] != chs2[i]) {
                if (chs1[i] == 'x') {
                    cntX++;
                } else {
                    cntY++;
                }
            }
        }
        int c1 = cntX / 2;
        int c2 = cntY / 2;
        if(cntX % 2 == cntY % 2)
            return c1 + c2 + (cntX % 2) * 2;
        return -1;
    }
}
