package leetcode;

/**
 * Created by ykp on 10/1/16.
 */
public class CopyListWithRandomPointer138 {

    public void displayList(RandomListNode head){
        while(head != null){
            System.out.print(head.label+" ");
            head = head.next;
        }
    }

    public RandomListNode copyRandomList(RandomListNode head) {

        if(head == null){
            return head;
        }


        RandomListNode another ;

        RandomListNode p1 = head;


        while(p1 != null){
            RandomListNode p = new RandomListNode(p1.label);

            RandomListNode temp = p1.next;

            p1.next = p;
            p.next = temp;

            p1 = temp;
        }

        another = head.next;

        p1 = head;
        RandomListNode p2 = another;
        while(p2.next != null){
            if(p1.random != null){
                p2.random = p1.random.next;
            }

            p1.next = p2.next;
            p2.next = p2.next.next;


            p1 = p1.next;
            p2 = p2.next;
        }


        return another;
    }


    public static void main(String[] args){
        CopyListWithRandomPointer138 copy = new CopyListWithRandomPointer138();
        RandomListNode root = new RandomListNode(1);
        RandomListNode two = new RandomListNode(2);
//        RandomListNode three = new RandomListNode(3);
//        RandomListNode four = new RandomListNode(4);
//        RandomListNode five = new RandomListNode(5);

        root.next = two;
//        two.next = three;
//        two.random = four;
//        three.next = four;
//        four.next = five;

        RandomListNode newList = copy.copyRandomList(root);

        copy.displayList(newList);
    }
}
