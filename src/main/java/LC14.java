/**
 * Leetcode第十四题，最长公共子串
 * 实现的一点也不优雅，没有考虑完善，直接写，编写边改就会这样
 * 整体思路就是对每个字符串的第i个字符进行比较，如果全部相等，则这是前缀的一部分，否则(0,i-1)是最长前缀
 * 用时：16m17s
 */
public class LC14 {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        int index = 0;
        boolean flag = true;
        while(flag) {
            int i = 0;
            for (i = 0; i < strs.length; i++) {
                if(i + 1 < strs.length) {
                    if(index < Math.min(strs[i].length(),strs[i+1].length())) {
                        if(strs[i].charAt(index) != strs[i+1].charAt(index)) {
                            flag = false;
                            break;
                        }
                    }
                    else{
                        flag = false;
                        break;
                    }
                } else if(strs.length == 1) {
                    return strs[0];
                }
            }
            if(i == strs.length) {
                index++;
            }
        }
        return strs[0].substring(0,index);

    }

    /**
     * 更清晰简洁的实现
     */
    public String longestCommonPrefix1(String[] strs) {
        int index = 0;

        if(strs.length == 1){
            return strs[0];
        }
        while(true) {
            int i = 0;
            //比较连续的两个字符串的第index字符，strs中至少有两个字符串
            for (i = 0; i < strs.length - 1; i++) {
                //如果索引大于任意一个的时候，则可以返回结果
                if(index >= strs[i].length() || index >= strs[i+1].length()) {
                    return strs[i].substring(0,index);
                }
                //如果出字符不相等，则可以返回结果
                if(strs[i].charAt(index) != strs[i+1].charAt(index)) {
                    return strs[i].substring(0,index);
                }
            }
            //开始对下一个字符进行比较
            index++;
        }
    }
}
