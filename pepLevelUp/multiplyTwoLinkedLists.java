import java.util.*;

public class multiplyTwoLinkedLists {

    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode multiplyLinkedLists(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        int s1 = 0;
        int s2 = 0;

        ListNode temp = l1;
        while (temp != null) {
            s1++;
            temp = temp.next;
        }

        temp = l2;
        while (temp != null) {
            s2++;
            temp = temp.next;
        }

        ListNode ans = new ListNode(0);
        temp = ans;

        for (int i = 0; i < s1 + s2 + 1; i++) {
            temp.next = new ListNode(0);
            temp = temp.next;
        }

        if (s1 < s2) {
            temp = l1;
            l1 = l2;
            l2 = temp;
        }

        int c = 0;
        ListNode temp2 = l2;

        temp = ans;

        while (temp2 != null) {
            ListNode t = temp;
            ListNode temp1 = l1;
            while (temp1 != null) {
                int mult = temp1.val * temp2.val + c + t.val;
                int quo = mult / 10;
                int rem = mult % 10;
                c = quo;
                t.val = rem;
                temp1 = temp1.next;
                t = t.next;
            }
            temp2 = temp2.next;
            temp = temp.next;
            while (c > 0) {
                int add = t.val + c;
                t.val = (add) % 10;
                c = (add) / 10;
                t = t.next;
            }
        }

        ans = reverse(ans);

        temp = ans;
        while (temp != null && temp.val == 0) {
            temp = temp.next;
        }
        return temp;
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode cur = head;
        ListNode temp = null;

        while (cur != null) {
            temp = cur.next;

            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    // InFput_code===================================================

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode makeList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = makeList(scn.nextInt());
        ListNode head2 = makeList(scn.nextInt());

        ListNode ans = multiplyLinkedLists(head1, head2);
        printList(ans);
    }
}
