public class Linkedlist {
    Node head;
    private int size;

    Linkedlist(){
        this.size=0;
    }
    class Node{
        String data;
        Node next;

        Node(String data){ //Constructor
            this.data=data;
            this.next=null;
            size++;
        }
    }
    //add- first
    public void addFirst(String data){
        Node newNode= new Node(data);
        if(head==null){
            head= newNode;
            return;
        }
        size++;
        newNode.next=head;
        head= newNode;
    }

    //add- last
    public void addLast(String data){
        Node newNode= new Node(data);
        if(head==null){
            head= newNode;
            return;
        }
        Node currNode=head;
        while (currNode.next!=null) {
            currNode= currNode.next;
            
        }
        size++;
        currNode= newNode;
    }
    //delete- first
    public void deleteFirst(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        size--;
        head.next=head;
    }

    //delete- last
    public void deleteLast(){
        if(head==null){
            System.out.println("list is empty");
            return;
        }
        size--;
        if(head.next==null){
            head= null;
            return;
        }
        Node secondLast= head;
        Node lastNode= head.next;
        while (lastNode.next!=null) {
            lastNode=lastNode.next;
            secondLast=secondLast.next;
            
        }
        size--;
        secondLast.next=null;
    }


    //print
    public void printList(){
        if(head==null){
            System.out.println("list is empty");
            return;
        }
        Node currNode=head;
        while (currNode!=null) {
            System.out.print(currNode.data+"->");
            currNode= currNode.next;
            
        }
        System.out.println("NULL");
    }

    public int getSize(){
        return size;
    }

    //reverse linkedlist
    public void reverseIterate(){
        if (head==null || head.next==null) {
            return;
        }

        Node prevNode= head;
        Node currNode= head.next;
        while(currNode != null){
            Node nextNode= currNode.next;
            currNode.next= prevNode;

            //update
            prevNode= currNode;
            currNode= nextNode;
        }
        head.next= null;
        head= prevNode;
    }
   
    public static void main(String[] args) {
        Linkedlist list= new Linkedlist();
        list.addFirst("a");
        list.addFirst("is");
        list.printList();

        list.addLast("list");
        list.printList();

        list.addFirst("this");
        list.printList();

        System.out.println(list.getSize());

        list.reverseIterate();
        list.printList();

    }
}
