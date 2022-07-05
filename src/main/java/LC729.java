import java.util.TreeMap;

/**
 * Leetcode729题，我的日程安排表
 * 关键字：设计、线段树、二分查找、有序集合
 * 主要思路：
 * 1. 我是比较偷懒了，直接用TreeMap来实现这道题
 * 2. start作为key，判断当前任务和前一个任务，后一个任务是否有交集
 * 3. 没有交集就可以加入map
 */
public class LC729 {
    TreeMap<Integer,int[]> map;
    public LC729() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer lowerKey = map.floorKey(start);
        Integer higherKey = map.ceilingKey(start);
        if(lowerKey != null) {
            int[] lowerP = map.get(lowerKey);
            if(start < lowerP[1]) return false;
        }
        if(higherKey != null) {
            int[] higherP = map.get(higherKey);
            if(end > higherP[0]) return false;
        }
        map.put(start,new int[]{start,end});
        return true;
    }
}

//todo 729题，我的日程安排表，使用线段树来实现