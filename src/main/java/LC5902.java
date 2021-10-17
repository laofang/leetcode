/**
 * Leetcode5902，竞赛题，检查句子中的数字是否递增
 * 主要思路：
 * 1. 按空格分割，判断每个字符串是否是数字
 * 2. 如果是数字，判断是否大于前一个，如果不大于，则不是递增
 */
public class LC5902 {
    public boolean areNumbersAscending(String s) {
        //按空格分割
        String[] strs = s.split("\\s+");
        int oldValue = 0;
        for(String str : strs) {
            if(isNum(str)) {
                int newValue = Integer.valueOf(str);
                //当前值与上一个数字对比
                if(oldValue >= newValue) {
                    return false;
                }
                oldValue = newValue;
            }
        }
        return true;
    }

    /**
     * 是否是数字
     */
    public boolean isNum(String str) {

        for(int i = 0;i < str.length();i++) {
            //如果这个字符串的每个值都是数字，则它是数字
            if(!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
