import java.util.LinkedList;

/**
 * Leetcode682题，棒球比赛
 * 关键字：栈、数组、模拟
 * 主要思路：
 * 1. 用一个链表作为栈
 * 2. 遇见'X'入栈，遇见'+'倒数两项之和入栈，遇见'D'倒数第一项*2入栈，遇见'C'出栈
 */
public class LC682 {
    public int calPoints(String[] ops) {
        LinkedList<Integer> list = new LinkedList<>();
        int ans = 0;
        for (int i = 0; i < ops.length; i++) {
            if(ops[i].equals("+")) {
                list.add(list.getLast() + list.get(list.size()-2));
                ans += list.getLast();
            } else if(ops[i].equals("D")) {
                list.add(list.getLast() * 2);
                ans += list.getLast();
            } else if(ops[i].equals("C")) {
                ans -= list.getLast();
                list.removeLast();
            } else {
                list.add(Integer.valueOf(ops[i]));
                ans += list.getLast();
            }
        }
        return ans;
    }
}
