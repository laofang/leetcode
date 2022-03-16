import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;

/**
 * Leetcode432题，O(1)的数据结构
 * 关键字：哈希表、有序集合、链表、双向链表
 * 主要思路：
 * 1. TreeSet和HashMap存放所有元素即可
 */
public class LC432 {
    Map<String,Model> map;
    //    PriorityQueue<Model> queue;
    TreeSet<Model> set;
    public LC432() {
        map = new HashMap<>();
        set= new TreeSet<>((a, b)->{
            if( a.value != b.value) {
                return a.value - b.value;
            } else {
                return a.key.compareTo(b.key);
            }
        });
    }

    public void inc(String key) {
        Model m = map.getOrDefault(key,new Model(key,0));
        set.remove(m);
        m.value++;
        if(m.value == 1) {
            map.put(key,m);
        }
        set.add(m);

    }

    public void dec(String key) {
        Model m = map.getOrDefault(key,new Model(key,0));
        if(m.value == 0) return;
        set.remove(m);
        m.value--;
        if(m.value == 0) {
            map.remove(m.key);
        } else {
            set.add(m);
        }
    }

    public String getMaxKey() {
        return  set.isEmpty() ? "" : set.last().key;
    }

    public String getMinKey() {
        return set.isEmpty() ? "" : set.first().key;
    }
}
class Model {
    Model(String key,int value) {
        this.key = key;
        this.value = value;
    }
    public String key;
    public int value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Model model = (Model) o;
        return key == model.key && Objects.equals(key, model.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
}