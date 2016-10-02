package leetcode;

/**
 * Created by ykp on 10/1/16.
 */
public class ReOrderList143 {

    public void displayList(ListNode head){
        while(head != null){
            System.out.print(head.val+" ");
            head = head.next;
        }
    }

    public ListNode reverseList(ListNode root){
        if(root == null || root.next == null){
            return root;
        }

        ListNode second = root.next;

        ListNode rest = reverseList(second);

        second.next = root;

        root.next = null;

        return rest;
    }

    public ListNode reorderList(ListNode root){

        ListNode fast = root;
        ListNode slow = root;

        while(true){
            if(fast.next != null){
                fast = fast.next;
                if(fast.next != null){
                    slow = slow.next;
                    fast = fast.next;
                }else{
                    break;
                }
            }else{
                break;
            }
        }


        ListNode list2 = slow.next;
        slow.next = null;

        list2 = reverseList(list2);
        ListNode list1 = root;
        while(list1 != null && list2 != null){
            ListNode temp1 = list1.next;
            ListNode temp2 = list2.next;

            list1.next = list2;
            list2.next = temp1;

            list1 = temp1;
            list2 = temp2;

        }

        return root;
    }

    public static void main(String[] args){
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
//        list.next.next.next = new ListNode(4);


        ReOrderList143 reorder = new ReOrderList143();
        reorder.displayList(reorder.reorderList(list));
    }
}
