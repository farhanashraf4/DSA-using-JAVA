public class LinkedlistPallindrome {
    Node head;
    int size;

    LinkedlistPallindrome(){
        this.size = 0;
    }

    class Node {
        int data;
        Node next;

        Node(int data) { // Constructor
            this.data = data;
            this.next = null;
        }
    }

    // add first
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            size++;
            return;
        }
        size++;
        newNode.next = head;
        head = newNode;
    }

    // add last
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            size++;
            return;
        }
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        size++;
        currNode.next = newNode;
    }

    public int getSize() {
        return size;
    }

    // reverse linked list
    public void reverseIterate() {
        if (head == null || head.next == null) {
            return;
        }

        Node prevNode = head;
        Node currNode = head.next;
        while (currNode != null) {
            Node nextNode = currNode.next;
            currNode.next = prevNode;

            // update
            prevNode = currNode;
            currNode = nextNode;
        }
        head.next = null;
        head = prevNode;
    }

    // find the middle of the linked list
    public Node findMiddle(Node head) {
        Node hare = head;
        Node turtle = head;

        while (hare != null && hare.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;
        }
        return turtle;
    }

    // check if the linked list is a palindrome
    public boolean isPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }

        // Find the middle of the linked list
        Node middle = findMiddle(head);

        // Reverse the second half of the linked list
        Node secondHalfStart = reverseList(middle);

        // Compare the first half with the reversed second half
        Node firstHalfStart = head;
        while (secondHalfStart != null) {
            if (firstHalfStart.data != secondHalfStart.data) {
                return false;
            }
            firstHalfStart = firstHalfStart.next;
            secondHalfStart = secondHalfStart.next;
        }
        return true;
    }

    // Helper method to reverse a linked list
    private Node reverseList(Node head) {
        Node prev = null;
        while (head != null) {
            Node nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;
    }

    // print
    public void printList() {
        if (head == null) {
            System.out.println("list is empty");
            return;
        }
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + "->");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        LinkedlistPallindrome list = new LinkedlistPallindrome();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(2);
        list.addFirst(1);
        System.out.println("Size: " + list.getSize());
        list.printList();
        System.out.println("Is palindrome: " + list.isPalindrome());
        list.reverseIterate();
        list.printList();
    }
}
