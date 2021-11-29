import java.util.PriorityQueue;

/**
 * Leetcode786题，第k个最小的素数分数
 * 关键字：队列、优先队列、二分法、双指针
 * 主要思路：
 * 1. arr[0]/arr[1 ~ n-1]、 arr[0] / arr[1]、 arr[0] / arr[2]、 arr[0] / arr[3] ……
 * 2. 每个a[0] / a[j]，可以看成以a[j]为分母的递增序列，将每个递增序列的第一个元素放入优先队列
 * 3. 找到当前优先队列中最小的 a[i]/a[j] ，将这个出队，如果 i+1 < j ，则将a[i+1]、a[j]入队
 */
public class LC786 {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        //优先队列 a/b , c/d 比较大小 即是 a * d 与 c * b
        PriorityQueue<int[]> queue = new PriorityQueue<>((e1, e2)->{
            return arr[e1[0]] * arr[e2[1]] - arr[e2[0]] * arr[e1[1]];
        });
        //将0 / 1 ~ n-1 入队
        for(int i = 1; i < arr.length;i++) {
            queue.offer(new int[]{0,i});
        }
        //出队前k-1个
        for(int i = 0; i < k-1; i++) {
            int[] temp = queue.poll();
            //当前这个队列里最小的，则将分子+1,再入队
            if(temp[0] + 1 != temp[1]) {
                queue.offer(new int[]{temp[0]+1,temp[1]});
            }
        }
        //返回第k个
        return new int[]{arr[queue.peek()[0]],arr[queue.peek()[1]]};
    }

    //TODO 786，第k个最小的素数分数，二分法和双指针算法，效率更高
}
