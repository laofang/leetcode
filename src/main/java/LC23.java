import java.util.Arrays;

/**
 * Leetcode23题，两两交换链表中的节点
 * 关键字：递归，分治，优先队列合并
 * 用时：22m33s
 * 主要思路：
 * 1. 我用的是分治递归的做法
 * 2. 这道题可以参考第21题，合并两个有序链表
 * 3. 然后分治思想将数组分为两个部分，分别合并，结果再合并两个有序链表
 */
public class LC23 {
    public ListNode mergeKLists(ListNode[] lists) {
    if(lists.length == 0) {
        return null;
    }
    if(lists.length == 1) {
        return lists[0];
    }
    int length = lists.length;
    //这里取值比较重要，之前取length/2-1出了问题，我觉得可以想一下两个元素的情况
    int half = length / 2;
    //分为左右两个数组
    ListNode[] leftList =  Arrays.copyOfRange(lists,0,half);
    ListNode[] rightList = Arrays.copyOfRange(lists,half,lists.length);
    //合并，已经合并后的左右两个列表
    return mergeTwoList(mergeKLists(leftList),mergeKLists(rightList));
}

    /**
     * 合并两个列表
     */
    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        if(l1.val < l2.val) {
            l1.next = mergeTwoList(l1.next,l2);
            return l1;
        }
        else {
            l2.next = mergeTwoList(l1,l2.next);
            return l2;
        }
    }
    //TODO 困难，合并k个升序链表，已用分治递归实现，有时间优先队列来实现一下
}
