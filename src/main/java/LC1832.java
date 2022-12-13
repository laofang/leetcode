/**
 * Leetcode1832题，判断句子是否为全字母句
 * 关键字：哈希表、字符串
 * 主要思路：
 * 1. 位运算，用int的低26位，'a'是第1位，'z'是第26位，如果低26位全为1就说明是全字母句
 */
public class LC1832 {
    public boolean checkIfPangram(String sentence) {
        char[] chs = sentence.toCharArray();
        int test = 0;
        int target = 0;
        for(int i = 0; i < 26; i++) target = target | (1 << i);
        for(int i = 0; i < chs.length; i++) {
            int index = chs[i] - 'a';
            test = test | (1 << index);
            if(target == test) return true;
        }
        return false;
    }
}
