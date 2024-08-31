import java.util.ArrayList;

public class BST {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left= null;
            this.right= null;
        }

    }

    public static Node insert(Node root, int val){
        if(root==null){
            root= new Node(val);
            return root;
        }
        if(root.data>val){
            //left subtree
            root.left= insert(root.left, val);
        }else{
            //right subtree
            root.right= insert(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static boolean search(Node root, int key){
        if(root==null){
            return false;
        }
        if(root.data>key){
            return search(root.left, key);

        }else if(root.data==key){
            return true;

        }else{
            return search(root.right, key);
        }

    }

    //delete a node
    public static Node delete(Node root, int val){
        if (root.data>val) {
            root.left= delete(root.left, val);
        }else if(root.data<val){
            root.right= delete(root.right, val);
        }else{//root.data==val
            //case1
            if(root.left==null && root.right==null){
                return null;
            }//case2
            if(root.left==null){
                return root.right;

            }else if(root.right==null){
                return root.left;
            
            }
            //case3
            Node IS= inOrderSuccessor(root.right);
            root.data= IS.data;
            root.right= delete(root.right, IS.data);
        }
        return root;

    }

    public static Node inOrderSuccessor(Node root){
        while(root.left!=null){
            root= root.left;
        }
        return root;
    }

    public static void printInRange(Node root, int X, int Y){
        if (root==null) {
            return;
        }

        if(root.data>=Y&& root.data<=X){
            printInRange(root.left, X, Y);
            System.out.println(root.data+" ");
            printInRange(root.right, X, Y);

        }else if(root.data>Y){
            printInRange(root.left, X, Y);
        
        }else{
            printInRange(root.right, X, Y);
        }
    }
    public static void printRoot2Leaf(Node root, ArrayList<Integer> path){
        if (root==null) {
            return;
        }
        path.add(root.data);

        //leaf
        if (root.left==null && root.right==null) {
            printPath(path);
        }else{//non leaf
            printRoot2Leaf(root.left, path);
            printRoot2Leaf(root.right, path);
        }
        path.remove(path.size()-1);
    }

    public static void printPath(ArrayList<Integer> path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+"->");
        }
    }

    public static void main(String[] args) {
        int value[]= {5,1,3,4,2,7};
        Node root= null;

        for(int i=0;i<value.length;i++){
            root= insert(root, value[i]);
        }

        inorder(root);
        System.out.println();

        if (search(root, 1)) {
            System.out.println("key found");
        }else{
            System.out.println("key Not found");
            
        }
        delete(root, 4);
        inorder(root);


        printInRange(root, 1, 2);
        System.out.println();

        printRoot2Leaf(root, new ArrayList<>());
    }
}
