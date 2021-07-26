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
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        int interval = 1;
        while(interval < lists.length){
            for(int i = 0; i < len-interval; i += interval*2){
                lists[i] = mergeList2(lists[i], lists[i+interval]);                            
                
            }
            interval = interval*2;
        }
        if(len > 0){
            return lists[0];
        }
        return null;
    }
    
    private ListNode mergeList2(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0);        
        ListNode ptr = head;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                ptr.next = l1;
                l1= l1.next;
            }
            else{
                ptr.next = l2;
                l2= l2.next;
             }
            ptr = ptr.next;
        }
        
        if(l1 != null){
            ptr.next = l1;
        }
        if(l2 != null){
            ptr.next = l2;
        }
        
        return head.next;
    }
}
