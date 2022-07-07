import java.util.Arrays;
import java.util.List;

/**
 * Leetcode648题，单词替换
 * 关键字：字典树、数组、哈希表、字符串
 * 主要思路：
 * 1. 构造字典树
 * 2. 遍历每一个句子中的单词，在字典树检索，如果到了end节点，就返回当前遍历过的字符组成的字符串
 * 3. 如果遍历到null节点，或字符串结束也没遇到end节点，返回字符串本身
 */
public class LC648 {
    public String replaceWords(List<String> dictionary, String sentence) {
        TireTreeNode root = new TireTreeNode();
        root.initial(dictionary);
        String[] strs = sentence.split("\\s+");
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < strs.length; i++) {
            strs[i] = root.getShortestPre(strs[i]);
            ans.append(strs[i]).append(" ");
        }
        return ans.toString().trim();
    }
    class TireTreeNode {
        TireTreeNode[] node;
        boolean isEnd = false;
        public TireTreeNode() {
            node = new TireTreeNode[26];
        }
        public void initial(List<String> strs) {
            for(String s : strs) {
                char[] chs = s.toCharArray();
                TireTreeNode p = this;
                for(int j = 0; j < chs.length;j++) {
                    int index = chs[j] - 'a';
                    if(p.node[index] == null) p.node[index] = new TireTreeNode();
                    p = p.node[index];
                    if(j == chs.length - 1) p.isEnd = true;
                }
            }
        }

        public String getShortestPre(String str) {
            char[] chs = str.toCharArray();
            TireTreeNode p = this;
            for(int i = 0; i < chs.length; i++) {
                int index = chs[i] - 'a';
                p = p.node[index];
                if(p == null) return str;
                if(p.isEnd) {
                    return new String(Arrays.copyOfRange(chs,0,i+1));
                }
            }
            return str;
        }
    }
}
