import java.util.*;
public class StackClassAL {

     class Stack {
        
        static ArrayList<Integer> list= new ArrayList<>();
        public boolean isStackEmpty() {
            return list.size()==0;
        }

        public void push(int data) {
            list.add(data);
        }

        public int pop() {
            if(isStackEmpty()){
                return -1;
            }
            int top= list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }

        public int peek() {
            if(isStackEmpty()){
                return -1;
            }
            return list.get(list.size()-1);
           
        }
    }

    public static void main(String[] args) {
        StackClassAL StackClassAL = new StackClassAL();
        StackClassAL.Stack s = StackClassAL.new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        while (!s.isStackEmpty()) {
            System.out.println(s.peek());
            s.pop();

            /*using java frame work
            Stack<Integer> ss=new Stack<>();
                s.push(1);
                s.push(2);
                s.push(3);
                s.push(4);

                while (!s.isStackEmpty()) {
                    System.out.println(s.peek());
                    s.pop();*/
                    
        }
    }
}
