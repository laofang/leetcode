/**
 * 两数相加，注意进位
 */
public class AddTwoNumbers {
    /**
     * 按加法竖式计算方法即可，注意进位
     * 注意事项：1. 循环结束的判定条件要有carry的判断
     * 出错的地方：
     * 1. 循环结束条件未判断carry，导致最后有进位的情况少了一个节点
     * 2. 返回值返回了l3.next,错把l3当作头指针，初始化是头指针，在运行过程中是动态指针，最后指向尾节点，所以要有个不变的头指针
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h1 = new ListNode();
        ListNode h2 = new ListNode();
        h1.next = l1;
        h2.next = l2;
        int carry = 0;
        ListNode l3 = new ListNode();
        ListNode h3 = l3;
        while (h1.next != null || h2.next != null || carry != 0) {
            int value1 = 0;
            int value2 = 0;
            if (h1.next != null) {
                value1 = h1.next.val;
                h1 = h1.next;
            }
            if (h2.next != null) {
                value2 = h2.next.val;
                h2 = h2.next;
            }
            int sum = value1 + value2 + carry;
            int val = sum % 10;
            carry = sum / 10;
            l3.next = new ListNode(val, null);
            l3 = l3.next;
        }
        return h3.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}