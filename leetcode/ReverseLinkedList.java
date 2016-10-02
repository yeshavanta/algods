package leetcode;

/**
 * Created by ykp on 10/1/16.
 */
public class ReverseLinkedList {

    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode p1 = head;
        ListNode p2 = head.next;
        head.next = null;

        while(p1 != null && p2 != null){
            ListNode temp = p2.next;
            p2.next  = p1;
            p1 = p2;
            p2 = temp;

        }

        return p1;
    }

    public void displayList(ListNode head){
        while(head != null){
            System.out.print(head.val+" ");
            head = head.next;
        }
    }

    public static void main(String[] args){
        ReverseLinkedList reverse = new ReverseLinkedList();
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
//        list.next.next.next = new ListNode(4);
        reverse.displayList(reverse.reverse(list));
    }
}
