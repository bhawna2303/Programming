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
    public void reorderList(ListNode head) {
        Deque<ListNode> deque = new LinkedList();
        
        while(head != null){
            deque.add(head);
            head = head.next;
        }
        boolean front = false;
        ListNode prev = deque.removeFirst();
         
        while(!deque.isEmpty()){
            ListNode curr;
            if(!front){
                curr = deque.removeLast();
            }
            else{
                curr = deque.removeFirst();
            }
            prev.next = curr;
            prev = curr;
            front = !front;
        }
        prev.next = null;
        
    }
}
