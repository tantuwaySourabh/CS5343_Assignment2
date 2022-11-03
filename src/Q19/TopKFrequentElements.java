package Q19;
/*
 * Given an integer array nums and an integer k, 
 * return the k most frequent elements. You may return the answer in any order.
 * 
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 */

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        
        for(int n:nums){
            count.put(n, count.getOrDefault(n,0) + 1);
        }
        
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1,n2) -> count.get(n1) -                                                     count.get(n2));
        
        for(int n: count.keySet()){
            heap.add(n);
            if(heap.size() > k){
                heap.poll();
            }
        }
        
        List<Integer> topK = new LinkedList<>();
        while(!heap.isEmpty()){
            topK.add(heap.poll());
        }
        Collections.reverse(topK);
        return topK.stream().mapToInt(Integer::intValue).toArray();
    }
    public static void main(String[] args) {
        int[] nums = new int[] {1,1,1,2,2,3};
        int[] ans = topKFrequent(nums, 2);
        for(int num: ans) {
            System.out.print(num+",");
        }
        System.out.println();
    }
}

/*
 * Time complexity : O(Nlogk) if k < N and O(N) in the particular case of N = k.
 * That ensures time complexity to be better than O(NlogN).
 * 
 * Space complexity : O(N + k)
 * to store the hash map with not more NN elements and a heap with kk elements.
 */


