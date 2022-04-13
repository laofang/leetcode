import java.util.*;

/**
 * Leetcode380题,O(1)时间插入、删除和获取随机元素
 * 关键字：设计、数组、哈希表、数学、随机化
 * 主要思路：
 * 1. 主要就是删除时，删除元素和最后一个元素交换，类似扑克随机抽牌的算法
 */
public class LC380 {
    Map<Integer,Integer> map = new HashMap<>(200000);
    List<Integer> list = new ArrayList<>(200000);
    public LC380() {

    }

    public boolean insert(int val) {
        if(map.get(val) != null) {
            return false;
        }
        map.put(val,list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        Integer index = 0;
        if((index = map.get(val)) == null) {
            return false;
        }
        int lastVal = list.get(list.size() - 1);
        map.put(lastVal,index);
        map.remove(val);

        Collections.swap(list,index,list.size()-1);
        list.remove(list.size()-1);
        return true;
    }

    public int getRandom() {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }
}
