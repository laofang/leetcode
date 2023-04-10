import java.util.Arrays;
import java.util.LinkedList;

/**
 * Leetcode1019题，链表中的下一个更大节点
 * 关键字：栈、数组、链表、单调栈
 * 主要思路：
 * 1. 使用单调栈，从前向后遍历入栈，当前如果比栈顶大，那么栈顶出栈，此时栈顶元素就直到后面更大的是谁了
 * 2. 如果用列表存储答案，最后需要排序和转化；如果直接用数组，又不知道初始的链表长度，这个可以根据数据量的大小，自行平衡内存和速度
 */
public class LC1019 {
    public int[] nextLargerNodes(ListNode head) {
        LinkedList<int[]> stack = new LinkedList<>();
//        ArrayList<int[]> ans = new ArrayList<>();
        int i = 0;
        ListNode node = head;
        int[] ans1 = new int[10000];
        while(node != null) {
            while(!stack.isEmpty() && node.val > stack.peek()[0]) {
                int[] top = stack.pop();
//                ans.add(new int[]{node.val,top[1]});
                ans1[top[1]] = node.val;
            }
            stack.push(new int[]{node.val,i});
            i++;
            node = node.next;
        }
        while(!stack.isEmpty()) {
//            ans.add(new int[]{0,stack.pop()[1]});
            ans1[stack.pop()[1]] = 0;
        }
//        return ans.stream().parallel().sorted((e1,e2)->e1[1]-e2[1]).mapToInt(e->e[0]).toArray();
        return Arrays.copyOfRange(ans1,0,i);
    }
}
