package DesignCircularQueue;

/**
 * Created by Green on 2018/8/6.
 */
public class MyCircularQueue {
    class Entry{
        private int value;
        private Entry next;
        Entry(){
            value = -1;
            next = null;
        }
        public void setValue(int v){
            value = v;
        }
        public void setNext(Entry entry){
            this.next = entry;
        }
    }

    private Entry front;
    private Entry end;
    private int size=0;
    private int maxSize=0;
    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        if(k<1){
            return;
        }
        maxSize = k;
        size = 0;
        front = new Entry();
        Entry last = front;
        for(int i=1; i<k; i++){
            Entry newEntry = new Entry();
            last.setNext(newEntry);
            last = newEntry;
        }
        last.setNext(front);
        end = last;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        size++;
        end = end.next;
        end.setValue(value);
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        size--;
        front = front.next;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if(isEmpty()){
            return -1;
        }else {
            return front.value;
        }
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if(isEmpty()){
            return -1;
        }else {
            return end.value;
        }

    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return size ==0;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return size == maxSize;
    }

    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // set the size to be 3
        System.out.println(circularQueue.enQueue(1));  // return true
        System.out.println(circularQueue.enQueue(2));  // return true
        System.out.println(circularQueue.enQueue(3));  // return true
        System.out.println(circularQueue.enQueue(4));  // return false, the queue is full
        System.out.println(circularQueue.Rear());  // return 3
        System.out.println(circularQueue.isFull());  // return true
        System.out.println(circularQueue.deQueue());  // return true
        System.out.println(circularQueue.enQueue(4));  // return true
        System.out.println(circularQueue.Rear());  // return 4

    }
}
