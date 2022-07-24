/**
 * Leetcode1184题，公交站间的距离
 * 关键字：数组
 * 主要思路：
 * 1.是一个环，算出start -> destination的距离和destination -> start距离
 * 2.返回两个距离更短的那一个
 */
public class LC1184 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int ans = 0;
        int ans1 = 0;
        if(destination < start){
            int temp = start;
            start = destination;
            destination = temp;
        }
        for(int i = 0; i < distance.length;i++)
        {   if(i >= start && i < destination) ans+=distance[i];
        else
            ans1+=distance[i];
        }
        return ans < ans1?ans:ans1;
    }
}
