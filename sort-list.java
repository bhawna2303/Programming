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
    public ListNode sortList(ListNode head) {        
        int len = findLength(head);
        if(len < 2){
            return head;
        }
        return sort(head, len);        
    }
    
    private ListNode sort(ListNode head, int len){    
        int leftsize = len/2;
        int rightsize = len - leftsize;
        ListNode h1 = head;
        ListNode h2 = findHead2(head, leftsize);
        
        if(leftsize > 1){
            h1 = sort(h1, leftsize);
        }
        if(rightsize > 1){
            h2 = sort(h2, rightsize);
        }      
        
        return mergeList(h1, h2);
    }
    
    private ListNode mergeList(ListNode h1, ListNode h2){        
        ListNode head;
        if(h1.val <= h2.val){
            head = h1;
            h1 = h1.next;
        }
        else{
            head = h2;
            h2 = h2.next;
        }
        ListNode ptr = head;
        while(h1 != null && h2 != null){
            if(h1.val <= h2.val){
                ptr.next = h1;
                h1 = h1.next;
            }
            else{
                ptr.next = h2;
                h2 = h2.next;
            }
            ptr = ptr.next;
        }
        
        if(h1 != null){
            ptr.next = h1;
        }
        if(h2 != null){
            ptr.next = h2;
        }
        return head;
    }
    
    private ListNode findHead2(ListNode head, int len){
        ListNode prev = head;
        while(len > 0 && head != null){
            prev = head;
            head = head.next;
            len--;
        }
        prev.next = null;
        return head;
    }
    
    private int findLength(ListNode head){
        int size =0;
        while(head != null){
            head = head.next;
            size++;
        }
        return size;
    }
}
