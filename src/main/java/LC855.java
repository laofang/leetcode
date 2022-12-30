import java.util.TreeSet;

/**
 * Leetcode855题，考场就座
 * 关键词：设计、有序集合、堆
 * 主要思路：
 * 1. 使用TreeSet有序集合，记录每一个在考场的学生位置
 * 2. 每当来一个学生，遍历有序集合，找到两个具有最大距离的相邻位置，进行设置
 */
public class LC855 {
    TreeSet<Integer> set;
    int max = 0;
    public LC855(int n) {
        set = new TreeSet<>();
        max = n-1;
    }

    public int seat() {
        int pos = 0;
        int size = set.size();
        if(size == 0) {
            set.add(0);
        } else if(size == 1) {
            int val = set.first();
            if(val - 0 >= max - val) {
                pos = 0;
            } else {
                pos = max;
            }
        } else {
            int cur = 0;
            int first = set.first();
            int last = set.last();
            int l = 0;
            for(int r : set) {
                if((r - l) / 2 > cur) {
                    cur = (r - l) / 2;
                    pos = l + (r - l) / 2;
                }
                l = r;
            }
            if(first - 0 >= cur) {
                cur = first - 0;
                pos = 0;
            }
            if(max - last > cur) {
                cur = max - last;
                pos = max;
            }
        }
        set.add(pos);
        return pos;
    }

    public void leave(int p) {
        set.remove(p);
    }
}
