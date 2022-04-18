import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode386题，字典序排数
 * 关键字：深度优先搜索、字典树
 * 主要思路：
 * 1. 先根据给定的数字范围，构造字典树
 * 2. 再深度优先遍历字典树
 */
public class LC386 {
    public List<Integer> lexicalOrder(int n) {
        Trie root = new Trie();
        LinkedList<Integer> ls = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            Trie r = root;
            int val = i;

            while(val != 0) {
                int v = val % 10;
                val /= 10;
                ls.push(v);
            }
            while(!ls.isEmpty()) {
                int v = ls.pop();
                if(r.next == null) r.next = new Trie[10];
                if(r.next[v] == null) r.next[v] = new Trie();
                r = r.next[v];
            }
        }
        Trie r = root;
        List<Integer> ans = new ArrayList<>();
        dfs(r,ans,0);
        return ans;
    }

    public void dfs(Trie t,List<Integer> list,int ans) {
        if(t.next != null) {
            for(int i = 0; i < t.next.length; i++){
                if(t.next[i] != null) {
                    ans = ans * 10 + i;
                    list.add(ans);
                    dfs(t.next[i],list,ans);
                    ans = (ans - i) / 10;
                }
            }
        }
    }

    class Trie {
        int val = -1;
        Trie[] next;
        public Trie() {

        }
    }
}
