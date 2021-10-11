import java.util.*;

/**
 * Leetcode二十一题，合并两个有序链表
 * 用时4m4s
 * 关键字：递归
 * 主要思路：
 * 1. 两个有序链表合并，可以看成找到最小的一个，将最小的一个的下一个指向剩余部分的排序结果
 */
public class LC21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        HashSet<Integer> s = new HashSet<Integer>();

        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

    //TODO面试网易时遇到的题，想再写一个非递归的解法
}
