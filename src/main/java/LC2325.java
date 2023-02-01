/**
 * Leetcode2325题，解密消息
 * 关键字：哈希表、字符串
 * 主要思路：
 * 1. 哈希表记录key中每个字符对应的真实字符
 * 2. 再遍历message，用hash表，将key中字符替换为真实字符
 */
public class LC2325 {
    public String decodeMessage(String key, String message) {
        int[] table = new int[26];
        int cur = 'a';
        for(int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            if(ch >= 'a' && ch <= 'z') {
                if(table[ch - 'a'] == 0) {
                    table[ch - 'a'] = cur++;
                }
            }
        }
        char[] mes = message.toCharArray();
        for(int i = 0; i < mes.length; i++) {
            if(mes[i] == ' ') continue;
            if(table[mes[i] - 'a'] != 0) {
                mes[i] = (char) table[mes[i] - 'a'];
            }
        }
        return new String(mes);
    }
}
