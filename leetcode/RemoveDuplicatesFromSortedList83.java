package leetcode;

/**
 * Created by ykp on 10/1/16.
 */
public class RemoveDuplicatesFromSortedList83 {

    public void displayList(ListNode head){
        while(head != null){
            System.out.print(head.val+" ");
            head = head.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode p1 = head;
        ListNode p2 = head;

        while(p1 != null){
            if(p1.val == p2.val){
                p1 = p1.next;
            }else{
                p2.next=p1;
                p2 = p2.next;
                p1 = p1.next;
            }
        }

        p2.next = p1;

        return head;
    }

    public static void main(String[] args){
        ListNode root = new ListNode(1);
        root.next = new ListNode(1);
        //root.next.next = new ListNode(2);

        RemoveDuplicatesFromSortedList83 remove = new RemoveDuplicatesFromSortedList83();
        remove.displayList(remove.deleteDuplicates(root));
    }
}
