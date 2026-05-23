// Time Complexity : O(n k) where n is the number of elements in the input array.
// Space Complexity :   O(1) where k is the input parameter.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// THIS IS intermediate approach where we are merging two lists at a time.
//  We can also use a min heap to keep track of the k smallest elements in the input array.
// in this approach we are merging two lists at a time and we are doing this for k lists.

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode merged = dummy;

        for (ListNode node : lists) {
            merged = merge(merged, node);
        }

        return dummy.next;
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (node1 != null && node2 != null) {
            
            if (node1.val < node2.val) {
                curr.next = node1;
                node1 = node1.next;
            } else {
                curr.next = node2;
                node2 = node2.next;
            }

            curr = curr.next;
        }

        if (node1 != null) {
            curr.next = node1;
        }

        if (node2 != null) {
            curr.next = node2;
        }

        return dummy.next;
    }
}