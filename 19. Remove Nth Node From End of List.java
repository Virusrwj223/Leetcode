//https://leetcode.com/problems/remove-nth-node-from-end-of-list/?envType=study-plan-v2&envId=top-interview-150
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
    ListNode mainHead;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        this.mainHead = head;
        helper(head, n);
        return this.mainHead;
    }

    public void helper(ListNode head, int n) {
        ListNode pointer = head;
        boolean isNull = false;
        int stoppedAt = 0;
        for (int i = 0; i <= n+1; i++) {
            if (pointer == null) {
                isNull = true;
                stoppedAt = i;
                break;
            }
            pointer = pointer.next;
        }

        if (isNull) {
            if (stoppedAt <= n) {
                this.mainHead = head.next;
                return;
            } else {
                ListNode checkNode = head.next;
                if (checkNode == null) {
                    this.mainHead = null;
                    return;
                }
                head.next = checkNode.next;
                return;
            }
            
        } else {
            helper(head.next, n--);
        }
    }
}
