// Time Complexity : O(n log k) where n is the number of elements in the input array and k is the number of lists. k is the number of lists and n is the total number of nodes across all lists.
// Space Complexity : O(k) where k is the number of lists. We are storing at most k nodes in the priority queue at any time.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We can use a min heap (priority queue) to keep track of the k smallest elements in the input array.
// We iterate through the array and add the head of each list to the min heap.
// We then repeatedly poll the smallest element from the min heap and add it to the merged list. 
// If the polled element has a next node, we add the next node to the min heap. 
// We continue this process until the min heap is empty, at which point we will have merged all the lists into one sorted list. 
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     
 *     ListNode() {}
 *     
 *     ListNode(int val) {
 *         this.val = val;
 *     }
 *     
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq = 
            new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode list : lists) {
            if (list != null) {
                pq.offer(list);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (!pq.isEmpty()) {

            ListNode min = pq.poll();

            curr.next = min;
            curr = curr.next;

            if (min.next != null) {
                pq.offer(min.next);
            }
        }

        return dummy.next;
    }
}