package leetcode;

/**
 * Created by ykp on 10/1/16.
 */
public class AddTwoNumbers2 {


    public ListNode getSum(ListNode head1, ListNode head2){

        if(head1 == null && head2 == null){
            return null;
        }

        if(head1 == null){
            return head2;
        }else if(head2 == null){
            return head1;
        }

        ListNode list3 = null;
        ListNode finalResult = new ListNode(-1);
        list3 = finalResult;
        ListNode list1 = head1;
        ListNode list2 = head2;

        int sum = 0;
        int carry = 0;

        while(list1 != null || list2 != null){

            if(list1 != null){
                sum = sum + list1.val;
                list1 = list1.next;
            }

            if(list2!=null){
                sum = sum + list2.val;
                list2 = list2.next;
            }

            sum = sum + carry;

            carry = sum /10;
            list3.next = new ListNode(sum%10);
            list3 = list3.next;
            sum = 0;

        }

        if(carry != 0){
            list3.next = new ListNode(carry);
        }


        return finalResult.next;

    }

    public void displayList(ListNode head){
        while(head != null){
            System.out.print(head.val+" ");
            head = head.next;
        }
    }

    public static void main(String[] args){
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);

        ListNode head2 = new ListNode(9);
        head2.next = new ListNode(8);
        head2.next.next = new ListNode(9);

        AddTwoNumbers2 add = new AddTwoNumbers2();
        add.displayList(add.getSum(head1,head2));
    }
}
