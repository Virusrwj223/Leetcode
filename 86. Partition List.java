//https://leetcode.com/problems/partition-list/description/?envType=study-plan-v2&envId=top-interview-150
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
    public ListNode partition(ListNode head, int x) {
        ListNode smallRegion = null;
        ListNode smallRegionP = null;
        ListNode preNumBigRegion = null;
        ListNode preNumBigRegionP = null;
        ListNode num = null;
        ListNode numP = null;
        ListNode bigRegion = null;
        ListNode bigRegionP = null;
        boolean visitedNum = false;
        while (head != null) {
            ListNode currHead = head;
            head = head.next;
            currHead.next = null;
            if (currHead.val < x) {
                if (smallRegion == null) {
                    smallRegion = currHead;
                    smallRegionP = smallRegion;
                } else {
                    smallRegionP.next = currHead;
                    smallRegionP = smallRegionP.next;
                }
            } else if (currHead.val > x && !visitedNum) {
                if (preNumBigRegion == null) {
                    preNumBigRegion = currHead;
                    preNumBigRegionP = preNumBigRegion;
                } else {
                    preNumBigRegionP.next = currHead;
                    preNumBigRegionP = preNumBigRegionP.next;
                }
            } else if (currHead.val == x && !visitedNum) {
                visitedNum = true;
                if (num == null) {
                    num = currHead;
                    numP = num;
                } else {
                    numP.next = currHead;
                    numP = numP.next;
                }
            } else {
                if (bigRegion == null) {
                    bigRegion = currHead;
                    bigRegionP = bigRegion;
                } else {
                    bigRegionP.next = currHead;
                    bigRegionP = bigRegionP.next;
                }
            }
        }

        ListNode endingPointer = null;
        ListNode startingPointer = null;
        for (int i = 0; i < 4; i++) {
            if(i == 0) {
                if (smallRegion == null) continue;
                if (endingPointer == null) {
                    endingPointer = smallRegionP;
                    startingPointer = smallRegion;
                }

            } else if (i == 1) {
                if (preNumBigRegion == null) continue;
                if (endingPointer == null) {
                    endingPointer = preNumBigRegionP;
                    startingPointer = preNumBigRegion;
                } else {
                    endingPointer.next = preNumBigRegion;
                    endingPointer = preNumBigRegionP;
                }
            } else if (i == 2) {
                if (num == null) continue;
                if (endingPointer == null) {
                    endingPointer = numP;
                    startingPointer = num;
                } else {
                    endingPointer.next = num;
                    endingPointer = numP;
                }
            } else {
                if (bigRegion == null) continue;
                if (endingPointer == null) {
                    endingPointer = bigRegionP;
                    startingPointer = bigRegion;
                } else {
                    endingPointer.next = bigRegion;
                    endingPointer = bigRegionP;
                }
            }
        }
        return startingPointer;
        
    }
}
