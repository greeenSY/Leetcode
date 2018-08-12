package FindMedianFromDataStream;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Green on 2018/8/9.
 */
class MedianFinder {

    List<Integer> list;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        if (list.isEmpty()) {
            list.add(num);
        } else {
            int index = findNumIndex(num, 0, list.size() - 1);
            list.add(index, num);
        }
    }

    private int findNumIndex(int num, int start, int end) {
        if (start == end) {
            if (list.get(start) < num) {
                return start + 1;
            } else {
                return start;
            }
        }
        int mid = (start + end) / 2;

        if (list.get(mid) == num) {
            return mid;
        } else if (list.get(mid) > num) {
            return findNumIndex(num, start, mid);
        } else {
            return findNumIndex(num, mid + 1, end);
        }
    }

    public double findMedian() {
        if (list.size() % 2 == 0) {
            return ((double) list.get(list.size() / 2) + (double) list.get(list.size() / 2 - 1)) / 2;
        } else {
            return (double) list.get(list.size() / 2);
        }
    }

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(-1);
        System.out.println(obj.findMedian());
        obj.addNum(-2);
        System.out.println(obj.findMedian());
        obj.addNum(-3);
        System.out.println(obj.findMedian());
        obj.addNum(-4);
        System.out.println(obj.findMedian());
        obj.addNum(-5);
        System.out.println(obj.findMedian());
    }
}

