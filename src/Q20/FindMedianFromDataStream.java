package Q20;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/find-median-from-data-stream/solution/
 * The median is the middle value in an ordered integer list. If the size of the list is even, 
 * there is no middle value and the median is the mean of the two middle values.
 * 
 * Explanation
 * MedianFinder medianFinder = new MedianFinder();
 * medianFinder.addNum(1);    // arr = [1]
 * medianFinder.addNum(2);    // arr = [1, 2]
 * medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
 * medianFinder.addNum(3);    // arr[1, 2, 3]
 * medianFinder.findMedian(); // return 2.0
 * 
 */
public class FindMedianFromDataStream {
    
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();

        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}

class MedianFinder {
    int item;
    
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    
    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || num < maxHeap.peek()) {
            maxHeap.offer(num);
        } else minHeap.offer(num);
        
        if(maxHeap.size() > minHeap.size() + 1){
            item = maxHeap.poll();
            minHeap.offer(item);
        } else if(minHeap.size() > maxHeap.size() + 1) {
            item = minHeap.poll();
            maxHeap.offer(item);
        }
    }
    
    public double findMedian() {
        if(minHeap.size() > maxHeap.size()) return minHeap.peek();
        else if(maxHeap.size() > minHeap.size()) return maxHeap.peek();
        else return (minHeap.peek() + maxHeap.peek() + 0.0) / 2;
    }
}

/*
 * Time Complexity: O(log N)
 * Space complexity: O(n) linear space to hold input in containers.
 */