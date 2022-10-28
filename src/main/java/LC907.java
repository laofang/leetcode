import java.util.Arrays;
import java.util.LinkedList;

/**
 * Leetcode907题，子数组的最小值之和
 * 关键字：栈、数组、动态规划、单调栈
 * 主要思路：
 * 1. arr中，找到每个值作为最小值的左右两个边界
 * 2. 例如，假设l，r分别是arr[i]的左右边界，则arr[i]在[i-l] * [r - i]个子数组中，提供了贡献，总贡献也就是arr[i] * [i-l] * [r - i]
 * 3. 如何高效率的求出arr[i]提供价值的左右界限，是当前的难点，可以采用单调栈
 * 4. 当前arr[i]与栈顶元素对比，如果比栈顶元素小，i就是栈顶元素的右边界，否则就出栈
 * 5. 重复上面的过程，直到栈顶元素小于等于arr[i]，则找到了arr[i]的左边界，即是栈顶元素的位置
 */
public class LC907 {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right,n);
        final int MOD = 1000000007;
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for(int i = 0; i < arr.length; i++) {
            int cur = arr[i];
            while(stack.size() >= 1) {
                int index = stack.peek();
                if(index == -1) break;
                if(arr[index] <= cur) break;
                if(cur < arr[index]) {
                    right[index] = i;
                    stack.pop();
                }
            }
            left[i] = stack.peek();
            stack.push(i);
        }
        long sum = 0;
        for(int i = 0; i < n; i++) {
            sum += ((long)arr[i] * (i - left[i])  * (right[i] - i)) % MOD;

        }
        return (int)(sum % MOD);
    }
}
