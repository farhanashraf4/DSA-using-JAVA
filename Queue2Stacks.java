import java.util.*;

public class Queue2Stacks {
    public static class Queue {
        public static Stack<Integer> s1 = new Stack<>();
        public static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        public static void add(int data) {
            // Move all elements from s1 to s2
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            // Push the new element into s1
            s1.push(data);

            // Push everything back to s1 from s2
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("Empty queue");
                return -1;
            }
            return s1.pop();
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Empty queue");
                return -1;
            }
            return s1.peek();
        }

        public static void main(String[] args) {
            Queue q = new Queue();
            q.add(1);
            q.add(2);
            q.add(3);
            q.add(4);
            q.add(5);

            while (!q.isEmpty()) {
                System.out.println(q.peek());
                q.remove();
            }
        }
    }
}
