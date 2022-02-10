import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode1447题，最简分数
 * 关键字：数学、约数、辗转相除
 * 主要思路：
 * 1. 双重循环，分子、分母没有公约数，则可以组成一个 i/j
 * 2. 字符串拼接使用StringBuilder效率有明显提高
 */
public class LC1447 {
    public List<String> simplifiedFractions(int n) {
        List<String> ans = new LinkedList<>();
        for (int i = 2; i <= n; i++) {
            for(int j = 1; j < i; j++) {
                if(j == 1) {
                    ans.add(1 + "/" + i);
                    continue;
                } else {
                    if(!hasDivisor(i,j)) {
                        ans.add(j + "/" + i);
                    }
                }
            }
        }
        return ans;
    }
    public boolean hasDivisor(int a,int b) {
        if(b == 0) {
            return true;
        } else if(b == 1) {
            return false;
        }
        return hasDivisor(b, a % b);
    }
}
