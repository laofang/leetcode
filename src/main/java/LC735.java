import java.util.Iterator;
import java.util.LinkedList;

/**
 * Leetcode735题，行星碰撞
 * 关键字：栈、数组
 * 主要思路：
 * 1. 使用栈进行模拟即可
 */
public class LC735 {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (int asteroid : asteroids) {
            Integer top = stack.peek();
            while(top != null && top > 0 && top <= -asteroid) {
                stack.pop();
                if(top == -asteroid) break;
                top = stack.peek();
            }
            if(top == null || asteroid > 0 || top < 0) {
                stack.push(asteroid);
                continue;
            }
        }
        int[] ans = new int[stack.size()];
        Iterator<Integer> iterator = stack.iterator();
        int i = ans.length;
        while(iterator.hasNext()) {
            ans[--i] = iterator.next();
        }
        return ans;
    }
}
