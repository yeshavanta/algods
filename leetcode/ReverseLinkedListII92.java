package leetcode;

/**
 * Created by ykp on 10/1/16.
 */
public class ReverseLinkedListII92 {

    public void displayList(ListNode head){
        while(head != null){
            System.out.print(head.val+" ");
            head = head.next;
        }
    }


    public ListNode reverseBetween(ListNode head, int m, int n) {
        int counter = 1;

        if(head == null || head.next == null || m == n){
            return head;
        }

        ListNode fake = new ListNode(-1);
        fake.next = head;
        ListNode start = null;
        ListNode pre = null;

        int i=1;
        start = head;

        while(i < m){
            pre = start;
            start = start.next;
            ++i;
        }

        if(pre == null){
            pre = fake;
        }

        ListNode p1 = start;
        ListNode p2 = start.next;
        p1.next = null;
        while( i < n){
            ListNode temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
            i++;
        }

        pre.next = p1;
        start.next = p2;

        return fake.next;
    }


    public static void main(String[] args){
        ReverseLinkedListII92 reverse = new ReverseLinkedListII92();
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        reverse.displayList(reverse.reverseBetween(root,1,2));
    }
}
