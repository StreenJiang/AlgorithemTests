package LinkedList;

import java.util.HashSet;
import java.util.Set;

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        Set<Integer> set = new HashSet<>();
        set.add(head.val);

        ListNode result = new ListNode(head.val);
        ListNode newCurr = result;
        ListNode curr = head;
        while (curr != null) {
            if (set.add(curr.val)) {
                newCurr.next = new ListNode(curr.val);
                newCurr = newCurr.next;
            }
            curr = curr.next;
        }

        return result;
    }
}
