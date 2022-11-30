import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Leetcode895题，最大频率栈
 * 关键字：栈、设计、哈希表、有序集合
 * 主要思路：
 * 1. 用一个优先级队列，按元素的数量，再按元素出现的时间，进行排列
 * 2. 用一个哈希表，记录元素对应的优先级队列中的数组
 * 3. 用一个哈希表，记录同一个元素，加入的时间栈
 * 4. 压入一个元素时，找到优先级队列对应的数组，进行更新，同时更新压入元素的时间栈
 * 5. 弹出一个元素时，找到优先级队列对应的数组，进行更新，同时更行弹出元素的时间栈
 * 优化：
 * 1. 按频率生成不同的频率栈，从最高的频率栈出栈就可以
 */
public class LC895 {
    private PriorityQueue<int[]> pq;
    private Map<Integer,int[]> map;
    private Map<Integer,LinkedList<Integer>> indexMap;
    private int stamp;
    public LC895() {
        pq = new PriorityQueue<>((e1,e2)->{
            if(e1[1] != e2[1]) return e2[1] - e1[1];
            return e2[2] - e1[2];
        });
        map = new HashMap<>();
        indexMap = new HashMap<>();
    }

    public void push(int val) {
        int[] value = map.get(val);
        LinkedList indexList = indexMap.getOrDefault(val,new LinkedList<>());
        if(value == null) {
            value = new int[]{val,1,++stamp};
            map.put(val,value);
        } else {
            pq.remove(value);
            value[1]++;
            indexList.push(value[2]);
            indexMap.put(val,indexList);
            value[2] = ++stamp;
        }
        pq.offer(value);
    }

    public int pop() {
        int[] value = pq.poll();
        int val = value[0];
        LinkedList<Integer> indexList = indexMap.get(val);
        if(value[1] == 1) {
            map.remove(val);
        } else {
            value[1]--;
            value[2] = indexList.pop();
            pq.offer(value);
        }
        return val;
    }
}
