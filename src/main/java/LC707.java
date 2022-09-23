/**
 * Leetcode707题，设计链表
 * 关键字：设计、链表
 * 主要思路：
 * 1. 设计了一个双向链表
 * 2. 在涉及指定指引的增删查，加了点优化，选择前和后与目标更近的位置，进行查找
 */
public class LC707 {
        int size;
        Node head;
        Node tail;
        public LC707() {
            head = new Node();
            tail = head;
            head.next = null;
            head.prev = null;
            size = 0;
        }

        public int get(int index) {
            if(index < 0 || index >= size) return -1;
            int half = size / 2;
            Node cur;
            if(index <= half) {
                int i = 0;
                cur = head;
                while(i <= index) {
                    cur = cur.next;
                    ++i;
                }
            } else {
                int i = size - 1;
                cur = tail;
                while (i > index) {
                    cur = cur.prev;
                    --i;
                }
            }
            return cur.val;
        }

        public void addAtHead(int val) {
            Node node = new Node(val);
            if(head == tail) {
                head.next = node;
                node.prev = head;
                tail = node;
            } else {
                Node firstNode = head.next;
                node.prev = head;
                node.next = firstNode;
                head.next = node;
                firstNode.prev = node;
            }
            ++size;
        }

        public void addAtTail(int val) {
            Node node = new Node(val);
            tail.next = node;
            node.prev = tail;
            node.next = null;
            tail = node;
            ++size;
        }

        public void addAtIndex(int index, int val) {
            if(index > size) return;
            if(index == size) {
                addAtTail(val);
                return;
            }
            if(index <= 0) {
                addAtHead(val);
                return;
            }
            int half = size / 2;
            Node cur;
            if(index <= half) {
                int i = 0;
                cur = head;
                while(i <= index) {
                    cur = cur.next;
                    ++i;
                }
            } else {
                int i = size - 1;
                cur = tail;
                while(i > index) {
                    cur = cur.prev;
                    --i;
                }
            }
            Node newNode = new Node(val);
            Node preNode = cur.prev;
            preNode.next = newNode;
            newNode.prev = preNode;
            newNode.next = cur;
            cur.prev = newNode;
            ++size;
        }

        public void deleteAtIndex(int index) {
            if(index < 0 || index >= size) return;
            int half = size / 2;
            Node cur;
            if(index <= half) {
                int i = 0;
                cur = head;
                while(i <= index) {
                    cur = cur.next;
                    ++i;
                }
            } else {
                int i = size - 1;
                cur = tail;
                while(i > index) {
                    cur = cur.prev;
                    --i;
                }
            }
            cur.prev.next = cur.next;
            if(cur != tail) {
                cur.next.prev = cur.prev;
            } else {
                tail = cur.prev;
            }
            --size;
        }
}
class Node {
    int val;
    Node next;
    Node prev;
    public Node(int val) {
        this.val = val;
    }
    public Node(){

    }
}

