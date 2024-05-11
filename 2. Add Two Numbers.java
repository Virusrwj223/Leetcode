///https://leetcode.com/problems/add-two-numbers/description/?envType=study-plan-v2&envId=top-interview-150
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rl1 = l1;
        ListNode rl2 = l2;
        
        ListNode result = new ListNode();
        int carry = 0;
        while (!isEmpty(rl1) || !isEmpty(rl2)) {
            if (!isEmpty(rl1) && isEmpty(rl2)) {
                rl2 = new ListNode(head(rl2), new ListNode(0, tail(rl2)));
            } else if(isEmpty(rl1) && !isEmpty(rl2)) {
                rl1 = new ListNode(head(rl1), new ListNode(0, tail(rl1)));
            } 

            int number = head(rl1) + head(rl2);
            
            int[] digits = digitify(number + carry);
            carry = digits[0];
            result = new ListNode(digits[1], result);
        
            rl1 = tail(rl1);
            rl2 = tail(rl2);
        }
        boolean isOverflowed = false;
        int number = head(rl1) + head(rl2);
        if (number + carry > 9) {
            isOverflowed = true;
        }
        int[] digits = digitify(number + carry);
        carry = digits[0];
        result = new ListNode(digits[1], result);
        if (isOverflowed) {
            result = new ListNode(carry, result);
        }

        ListNode finals = new ListNode(head(result));
        result = tail(result);
        while (!isEmpty(result)) {
            finals = new ListNode(head(result), finals);
            result = tail(result);
        }
        
        return finals;
    }

    public int[] digitify(int number) {
        if (number / 10 >= 1) {
            int carry = number / 10;
            int remainder = number - carry * 10;
            return new int[] {carry, remainder};
        } else {
            return new int[]{0, number};
        }
    }

    public int head(ListNode l) {
        return l.val;
    }

    public ListNode tail(ListNode l) {
        return l.next;
    }

    public boolean isEmpty(ListNode l) {
        return l.next == null;
    }
}
