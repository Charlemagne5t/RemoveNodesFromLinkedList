import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public ListNode removeNodes(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode res = null;
        while (head != null) {
            if (stack.isEmpty()) {
                stack.push(head);
                res = head;
                head = head.next;
                continue;
            }
            if (stack.peek().val >= head.val) {
                stack.push(head);
                head = head.next;
                continue;
            }
            while (!stack.isEmpty() && stack.peek().val < head.val) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                res = head;

            } else {
                stack.peek().next = head;
            }
            stack.push(head);

            head = head.next;
        }

        return res;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
