import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode472题，连接词
 * 关键字：字符串、Tire、字典树、前缀树、DFS、深度优先搜索、数组、动态规划
 * 主要思路：
 * 1. 将字符数组按长度进行排序
 * 2. 遍历字符串数组
 *      1. 在字典树中使用DFS(深度优先搜索)对字符串进行搜索
 *      2. 如果是连接词，加入答案，如果不是加入字典树
 */
public class LC472 {
    Trie trie = new Trie();
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(e->e.length()));
        List<String> ans = new LinkedList<>();
        for (String word : words) {
            if(word.length() == 0) {
                continue;
            }
            //先深搜，如果是连接词，加入答案
            if(dfs(word,0)) {
                ans.add(word);
                //否则加入字典树
            } else {
                trie.insert(word);
            }
        }
        return ans;
    }

    /**
     * 深度优先搜索
     * @param word 待判断的词
     * @param start 搜索的开始位置
     * @return 是否是连接词
     */
    public boolean dfs(String word,int start) {
        //整个字符串搜索完毕，是连接词
        if(start == word.length()) {
            return true;
        }
        //从字典树的根开始
        Trie t = trie;
        //深度搜索部分
        for(int i = start; i < word.length(); i++) {
            //当前的字符
            char ch = word.charAt(i);
            //对应的子树的节点索引
            int index = ch - 'a';
            t = t.children[index];
            //字符对应的子节点存在，而且还是终止的，那就从下一个字符开始进行遍历
            if(t != null) {
                if(t.isEnd) {
                    //如果后部分搜索成功，则返回成功，否则，继续遍历当前下一个字符
                    if(dfs(word,i + 1)) {
                        return true;
                    }
                }
                //如果当前这个字符不匹配，回到上一层
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * 字典树数据结构
     */
    class Trie {
        //子节点
        Trie[] children;
        //是否是终止节点
        boolean isEnd;
        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }

        /**
         * 字典树添加字符串
         * @param word 将要添加的字符串
         */
        public void insert(String word) {
            Trie cur = this;
            //遍历每一个字符，如果对应的子节点不存在就创建一个，向下走一个节点，继续
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                Trie t = cur.children[index];
                if(t == null) {
                    t = new Trie();
                    cur.children[index] = t;
                }
                cur = t;
            }
            //字符串最后一个字符对应的节点是终止节点
            cur.isEnd = true;
        }
    }
}
