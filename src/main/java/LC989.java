import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode989题，数组形式的整数加法
 * 关键字：数组、数学
 * 主要思路：
 * 1. 模拟加法竖式相加规则
 */
public class LC989 {
    public List<Integer> addToArrayForm(int[] num, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        int i = num.length - 1;
        int carry = 0;
        while (i >= 0 || k > 0) {
            int num1 = 0;
            if(i >= 0) {
                num1 = num[i];
                i--;
            }
            int num2 = 0;
            if(k > 0) {
                num2 = k % 10;
                k /= 10;
            }
            int sum = num1 + num2 + carry;
            carry = sum >= 10 ? 1 : 0;
            list.addFirst(sum % 10);
        }
        if(carry > 0) list.addFirst(carry);
        return list;
    }
}
