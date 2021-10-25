/**
 * Leetcode2047题，比赛题，句子中的有效单词数
 * 关键字： 字符串，正则
 * 主要思路：
 * 1. 按规则来判断就好
 */
public class LC2047 {
    public int countValidWords(String sentence) {
        String[] strs = sentence.trim().split("\\s+");
        int count=0;

        for(int i = 0; i < strs.length ; i++) {

            int j = 0;
            int chCount = 0;
            for(j = 0; j < strs[i].length(); j++) {
                char ch = strs[i].charAt(j);
                //'-'情况
                if(ch == '-') {
                    //‘-’超过两个
                    if(chCount > 0) {
                        break;
                    }
                    //第一个或者最后一个是'-'
                    if(j == 0 || j==strs[i].length() - 1 ) {
                        break;
                        //‘-’左和右不是[a,z]
                    } else if(strs[i].charAt(j-1) > 'z' || strs[i].charAt(j-1) < 'a' || strs[i].charAt(j+1)> 'z' || strs[i].charAt(j+1) < 'a') {
                        break;
                    }
                    //‘-’数量+1
                    chCount++;
                }
                //如果有数字，当前字符串无效
                else if(ch >= '0' && ch <= '9') {
                    break;
                }//标点情况
                else if(ch > 'z' || ch < 'a') {
                    //最后一个不能是[a,z]
                    if(j != strs[i].length() - 1) {
                        break;
                    }
                }
            }
            //如果字符串有效，增加计数
            if(j == strs[i].length()) {
                // System.out.println(i + " " + j);
                count++;
            }

        }
        return count;
    }
}
