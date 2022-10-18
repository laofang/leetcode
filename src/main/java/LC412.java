import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode412题，Fizz Buzz
 * 关键字：数学、字符串、模拟
 * 主要思路：
 * 1. 模拟即可
 */
public class LC412 {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>(n);
        for(int i = 1; i <= n; i++) {
            if(i % 3 == 0 && i % 5 == 0) {
                ans.add("FizzBuzz");
            } else if(i % 3 == 0) {
                ans.add("Fizz");
            } else if(i % 5 == 0) {
                ans.add("Buzz");
            } else {
                ans.add(String.valueOf(i));
            }
        }
        return ans;
    }
}

//todo 逃课902题，困难，最大为N的数字组合，经典数位dp题目
