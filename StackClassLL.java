public class StackClassLL {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Stack {
        private Node head; // Not static, to support multiple stack instances

        public boolean isStackEmpty() {
            return head == null;
        }

        public void push(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }

        public int pop() {
            if (isStackEmpty()) {
               return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        public int peek() {
            if (isStackEmpty()) {
                return -1;
            }
            return head.data;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        while (!s.isStackEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
