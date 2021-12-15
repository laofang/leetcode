import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Leetcode851题，喧闹和富有
 * 关键字：队列、数组、列表、图、树
 * 主要思路：
 * 用队列解决问题，将每一个元素作为一个列表的头，直接比他大的放在他的后面，
 * 将比他大的拿出来，放入队列，再循环这个过程，找到所有间接大于他的元素
 * 然后再比较这些人对应安静值最小的

 * 优化：
 * 可以记忆化搜索
 * 假设： 我查找比0大的元素，比person[0]大的有person[1],person[2],比person[1]大的有person[5]
 * person[5]的安静值最小
 * 则person[0] -> person[5]的路径上所有的人的最小安静值就是quiet[5]
 * ans[0] = 5,ans[1] = 5,ans[5] = 5
 */
public class LC851 {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        //人数
        int n = quiet.length;
        // 0  存储比0大的元素
        // 1  存储比1大的元素
        // 2  存储比2大的元素
        // ……  依次存储
        List<List<Integer>> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            List<Integer> l = new LinkedList<>();
            list.add(l);
        }
        // 遍历每一个财富大小关系，进行存储
        for (int i = 0; i < richer.length; i++) {
            int[] temp = richer[i];
            List l = list.get(temp[1]);
            l.add(temp[0]);
        }
        int[] ans = new int[n];
        // 队列，访问每一个元素对应的列表，广度优先搜索
        Queue<List<Integer>> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            //每个列表对应的元素
            int min = quiet[i];
            int res = i;
            queue.offer(list.get(i));
            //队不空就继续
            while(!queue.isEmpty()) {
                List<Integer> l = queue.poll();
                //比当前元素大的元素
                for(int k : l) {
                    //已经算过结果，直接用，不用入队在广搜
                    if(k < i) {
                        if(quiet[ans[k]] < min) {
                            min = quiet[ans[k]];
                            res = ans[k];
                        }
                        //没有计算过，还是要对当前节点广搜
                    } else {
                        if(quiet[k] < min) {
                            min = quiet[k];
                            res = k;
                        }
                        queue.offer(list.get(k));
                    }
                }
            }
            //结果
            ans[i] = res;
        }
        return ans;
    }
}
