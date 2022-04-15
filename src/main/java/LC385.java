import structure.NestedInteger;

/**
 * Leetcode385题，迷你语法分析器
 * 关键字：栈、深度优先搜索、字符串
 * 主要思路：
 * 1. 可以递归来做
 * 2. 列表中的元素可能是数字，也可能是列表
 * 3. 解析过程，就是对每一个元素生成一个对象，同时列表元素可以嵌套，这就是一个递归
 */
public class LC385 {
    int index = 0;
    public NestedInteger deserialize(String s) {
        if(s.charAt(index) == '[') {
            index++;
            NestedInteger ni = new NestedInteger();
            while(s.charAt(index) != ']') {
                ni.add(deserialize(s));
                if(s.charAt(index) == ',') index++;
            }
            index++;
            return ni;
        } else {
            boolean negative = false;
            if(s.charAt(index) == '-') {
                negative = true;
                index++;
            }
            int num = 0;
            while(index < s.length() && Character.isDigit(s.charAt(index))) {
                num = num * 10 + (s.charAt(index) - '0');
                index++;
            }

            if(negative) {
                num *= -1;
            }
            return new NestedInteger(num);
        }
    }
}
