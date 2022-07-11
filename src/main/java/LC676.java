import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode676题，实现一个魔法字典
 * 关键字：设计、字典树、哈希表、字符串
 * 主要思路：
 * 1. 模拟
 * 2. 将给定的字典建立哈希表
 * 3. 遍历searchWord替换一个字符的各种可能，每一个新的都去检查字典hash表里是否存在
 */
public class LC676 {
    Map<String,Boolean> map = new HashMap<>();
    int[] lengthTable = new int[101];
    public LC676() {

    }

    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            lengthTable[s.length()] = 1;
            map.put(s,true);
        }
    }

    public boolean search(String searchWord) {
        if(lengthTable[searchWord.length()] == 0) return false;
        char[] chs = searchWord.toCharArray();
        for(int i = 0; i < searchWord.length(); i++) {
            if(i > 0) chs[i-1] = searchWord.charAt(i-1);
            char ch = 'a';
            while(ch <= 'z') {
                if(searchWord.charAt(i) != ch) {
                    chs[i] = ch;
                    if(map.getOrDefault(new String(chs),false)) return true;
                }
                ch++;
            }
        }
        return false;
    }
}
//todo LC676，实现一个魔法字典，可以用前缀树来实现