//https://leetcode.com/problems/rotate-list/?envType=study-plan-v2&envId=top-interview-150
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        ArrayList<Integer> holding = new ArrayList<>();
        while (head != null) {
            holding.add(head.val);
            head = head.next;
        }
        int[] arr = new int[holding.size()];
        for (int i = 0; i < holding.size(); i++) {
            arr[i] = holding.get(i);
        }
        rotate(arr, k);
        ListNode returnable = new ListNode(arr[0]);
        ListNode pointer = returnable;
        for (int i = 1; i < holding.size(); i++) {
            pointer.next = new ListNode(arr[i]);
            pointer = pointer.next;
        }
        return returnable;
        
    }
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int displacedStartIndex = nums.length - k;
        int[] result = new int[nums.length];
        for (int i = 0; i < k; i++) {
            result[i] = nums[displacedStartIndex + i];
        }
        int counter = 0;
        for (int i = k; i < nums.length; i++) {
            result[i] = nums[counter];
            counter++;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }
}
