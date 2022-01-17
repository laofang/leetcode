
class LC82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode l = new ListNode();
        l.next = head;
        ListNode ans = l;
        while(l.next != null) {
            ListNode first = l.next;
            while(first.next != null && first.next.val == first.val) {
                first = first.next;
            }
            if(first != l.next) {
                l.next = first.next;
            } else {
                l = l.next;
            }
//            l = l.next;
        }
        return ans.next;
    }
}
