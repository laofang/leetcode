import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode728题，自除数
 * 关键字：数字
 * 主要思路：
 * 1. 双重循环遍历即可
 */
public class LC728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        while(left <= right) {
            int temp = left;
            while(temp != 0) {
                if (temp % 10 == 0 || left % ( temp % 10) != 0) break;
                temp /= 10;
            }
            if(temp == 0) {
                ans.add(left);
            }
            ++left;
        }
        return ans;
    }
}
