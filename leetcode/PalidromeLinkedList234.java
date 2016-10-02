package leetcode;

/**
 * Created by ykp on 10/2/16.
 */
public class PalidromeLinkedList234 {

    public ListNode reverseList(ListNode root){

        if(root == null || root.next == null){
            return root;
        }

        ListNode p1 = root;
        ListNode p2 = root.next;
        p1.next = null;

        while(p2 != null){
            ListNode temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }

        return p1;

    }

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        if(head == null){
            return true;
        }

        while(true){
            if(fast.next != null){
                fast = fast.next;

                if(fast.next == null){
                    break;
                }

                if(fast.next != null){
                    slow = slow.next;
                    fast = fast.next;
                }
            }else{
                break;
            }
        }

        ListNode p1 = head;
        ListNode p2 = slow.next;
        slow.next = null;

        p2 = reverseList(p2);

        while(p1 != null && p2 != null){
            if(p1.val != p2.val){
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }

    public static void main(String[] args){
        PalidromeLinkedList234 palindrome = new PalidromeLinkedList234();
        ListNode root = new ListNode(1);
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(1);
        root.next.next.next.next = new ListNode(1);
        if(palindrome.isPalindrome(root)){
            System.out.println("TRUE");
        }else{
            System.out.println("FALSE");
        }
    }
}
