import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode241题，为运算表达式设计优先级
 * 关键字：递归、记忆化搜索、数学、字符串、动态规划
 * 主要思路：
 * 1. 使用分治递归的思想，整个算式可以看作 x op y的形式
 * 2. 遍历每个字符，如果是运算符，就可以把表达式分成 x op y
 * 3. 然后对x 和 y分别递归，可以求得两个x会对应一个结果集合l1，y会对应一个结果集合l2
 * 4. 分别将l1和l2中的每个答案根据op符号，进行运算，加入当前结果列表返回
 */
public class LC241 {
    public List<Integer> diffWaysToCompute(String expression) {

        return divideAndConquer(expression,0,expression.length()-1);
    }

    public List<Integer> divideAndConquer(String expression,int start,int end) {
        List<Integer> ans = new ArrayList<>();
        if(expression.length() < 3) {
            ans.add(Integer.valueOf(expression));
            return ans;
        }
        for(int i = 0; i < expression.length();i++ ) {
            char ch = expression.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*') {
                String pre = expression.substring(0,i);
                String after = expression.substring(i+1);
                List<Integer> l1 = divideAndConquer(pre,start,start + i - 1);
                List<Integer> l2 = divideAndConquer(after,start + i + 1,end);
                for(int a : l1) {
                    for(int b : l2) {
                        int k = 0;
                        if(ch == '+') {
                            k = a + b;
                        } else if(ch == '-') {
                            k = a - b;
                        } else {
                            k = a * b;
                        }
                        ans.add(k);
                    }
                }

            }

        }
        return ans;
    }
}
