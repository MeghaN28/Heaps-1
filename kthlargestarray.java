// Time Complexity : O(n log k) where n is the number of elements in the input array.
// Space Complexity : O(k) where k is the input parameter.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We can use a min heap to keep track of the k largest elements in the input array.
//  We iterate through the array and add each element to the min heap. 
// If the size of the min heap exceeds k, we remove the smallest element from the heap.
//  After processing all elements, the top of the min heap will be the kth largest element in the array.

// We can also use a max heap to keep track of the k largest elements in the input array.
// We iterate through the array and add each element to the max heap. 
// If the size of the max heap exceeds k, we remove the largest element from the heap. (N-K+1 th element)
// After processing all elements, the top of the max heap will be the kth largest element in the array.

import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.offer(num);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }
}