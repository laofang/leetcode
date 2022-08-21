/**
 * Leetcode1455题，检查单词是否为句中其他单词的前缀
 * 关键字：字符串、字符串匹配
 * 主要思路：
 * 1. 字符串匹配，待匹配字符串与句字符串进行匹配
 * 2. 遇到空格，就是一个新的字符串
 */
public class LC1455 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        char[] sw = searchWord.toCharArray();
        char[] ss = sentence.toCharArray();
        int i = 0;
        int count = 1;
        while(i < ss.length) {
            int j = 0;
            while(i < ss.length && ss[i] == sw[j]) {
                i++;
                j++;
                if(j == sw.length) return count;
            }
            
            while(i < ss.length) {
                if(ss[i] == ' ') {
                    count++;
                    break;
                }
                i++;
            }
            i++;
        }
        return -1;
    }
}
