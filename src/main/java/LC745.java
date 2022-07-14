import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode745题，前缀和后缀搜索
 * 关键字：设计、字典树、字符串
 * 主要思路：
 * 1. 根据已知的字符串数组，将每个字符串按从前到后的顺序，和从后到前的顺序，分别构造前缀字典树和后缀字典树
 * 2. 字典树节点要记录，可达到当前节点字符串在字符串数组中的索引
 * 3. 查找的时候，分别从前缀字典树和后缀字典树进行查找
 * 4. 最后用双指针，找到两个列表中共有的最大值的索引
 */
public class LC745 {
    Tire head = new Tire();
    Tire tail = new Tire();
    public LC745(String[] words) {
        for (int i = 0; i < words.length; i++) {
            Tire ph = head;
            Tire pt = tail;
            char[] chs = words[i].toCharArray();
            for(int j = 0; j < chs.length; j++) {
                if(ph.nodes[chs[j] - 'a'] == null) {
                    ph.nodes[chs[j] - 'a'] = new Tire();
                }
                ph = ph.nodes[chs[j] - 'a'];
                ph.indexs.add(i);
                if(pt.nodes[chs[chs.length - 1 - j] - 'a'] == null) {
                    pt.nodes[chs[chs.length - 1 - j] - 'a'] = new Tire();
                }
                pt = pt.nodes[chs[chs.length - 1 - j] - 'a'];
                pt.indexs.add(i);

            }
            ph.isEnd = true;
            pt.isEnd = true;
        }
    }

    public int f(String pref, String suff) {
        char[] prChs = pref.toCharArray();
        char[] suChs = suff.toCharArray();
        Tire ph = head;
        Tire pt = tail;
        List<Integer> l1 = null;
        List<Integer> l2 = null;
        int i = 0;
        for (; i < prChs.length; i++) {
            ph = ph.nodes[prChs[i] - 'a'];
            if(ph == null) {
                return -1;
            }
        }
        if(i == prChs.length) l1 = ph.indexs;
        int j = suChs.length - 1;
        for (; j >= 0; j--) {
            pt = pt.nodes[suChs[j] - 'a'];
            if(pt == null) {
                return -1;
            }
        }
        if(j == -1) l2 = pt.indexs;
        if(l1 == null || l2 == null) return -1;
        i = l1.size()-1;
        j = l2.size()-1;
        while(j >= 0 && i >= 0) {
            int a = l1.get(i);
            int b = l2.get(j);
            if(a == b) {
                return a;
            } else if(a > b) {
                i--;
            } else {
                j--;
            }
        }
        return -1;
    }
    class Tire{
        Tire[] nodes;
        boolean isEnd;
        List<Integer> indexs;
        public Tire() {
            this.nodes = new Tire[26];
            isEnd = false;
            indexs = new ArrayList<>();
        }
    }
}
