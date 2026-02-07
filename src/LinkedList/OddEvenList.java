package LinkedList;

public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddHead = head;
        ListNode oddTail = head;
        ListNode evenHead = head.next;
        ListNode evenTail = head.next;

        int position = 3;
        ListNode current = evenTail.next;

        while (current != null) {
            if (position % 2 == 1) {
                oddTail.next = current;
                oddTail = current;
            } else {
                evenTail.next = current;
                evenTail = current;
            }
            current = current.next;
            position++;
        }

        evenTail.next = null;
        oddTail.next = evenHead;
        return oddHead;
    }

    static void main(String[] args) {
        OddEvenList sol = new OddEvenList();

        // 测试1: [1,2,3,4,5] → [1,3,5,2,4]
        ListNode head1 = createList(new int[]{1,2,3,4,5});
        printList("输入: ", head1);
        ListNode result1 = sol.oddEvenList(head1);
        printList("输出: ", result1);

        // 测试2: [2,1,3,5,6,4,7] → [2,3,6,7,1,5,4]
        ListNode head2 = createList(new int[]{2,1,3,5,6,4,7});
        printList("输入: ", head2);
        ListNode result2 = sol.oddEvenList(head2);
        printList("输出: ", result2);

        // 测试3: 单节点
        ListNode head3 = createList(new int[]{1});
        printList("输入: ", head3);
        ListNode result3 = sol.oddEvenList(head3);
        printList("输出: ", result3);

        // 测试4: 两节点
        ListNode head4 = createList(new int[]{1,2});
        printList("输入: ", head4);
        ListNode result4 = sol.oddEvenList(head4);
        printList("输出: ", result4);
    }

    // 辅助函数：创建链表
    private static ListNode createList(int[] vals) {
        if (vals.length == 0) return null;
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        for (int val : vals) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    // 辅助函数：打印链表
    private static void printList(String prefix, ListNode head) {
        System.out.print(prefix);
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }
}
