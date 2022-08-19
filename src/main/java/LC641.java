/**
 * Leetcode641题，设计循环双端队列
 * 关键字：设计、队列、数组、链表
 * 主要思路：
 * 1. 空队时，front==rear
 * 2. 非空时，front指向队首元素，rear指向队尾的下一个位置
 * 3. 满队时，(rear + 1) % length == head
 * 4. 数组元素要多一个，这样可以区分满队和空队的情况
 */
public class LC641 {
    int[] queue;
    int head = 0;
    int tail = 0;
    public LC641(int k) {
        queue = new int[k+1];
    }

    public boolean insertFront(int value) {
        int curHead = head - 1 >= 0 ? head - 1 : queue.length - 1;
        if(curHead == tail) return false;
        head = curHead;
        queue[head] = value;
        return true;
    }

    public boolean insertLast(int value) {
        int curTail = tail + 1 == queue.length ? 0 : tail + 1;
        if(curTail == head) return false;
        queue[tail] = value;
        tail = curTail;
        return true;
    }

    public boolean deleteFront() {
        if(head == tail) return false;
        head = head + 1 == queue.length ? 0 : head + 1;
        return true;
    }

    public boolean deleteLast() {
        if(head == tail) return false;
        tail = tail - 1 < 0 ? tail = queue.length - 1 : tail - 1;
        return true;
    }

    public int getFront() {
        if(head == tail) return -1;
        return queue[head];
    }

    public int getRear() {
        if(head == tail) return -1;
        int index = tail - 1 < 0 ? queue.length - 1 : tail - 1;
        return queue[index];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        int nextTail = (tail + 1) % queue.length;
        return head == nextTail;
    }
}
