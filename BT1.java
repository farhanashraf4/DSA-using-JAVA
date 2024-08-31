import java.util.*;
public class BT1 {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        static int indx = -1;

        public static Node buildTree(int[] nodes){
            indx++;
            if(nodes[indx] == -1){
                return null;
            }

            Node newNode = new Node(nodes[indx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }
    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void postorder(Node root){
        if(root==null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }

    public static void levelorder(Node root) {
        if(root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()) {
            Node currNode = q.remove();
            if(currNode == null) {
                System.out.println();
                //queue empty
                if(q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data+" ");
                if(currNode.left != null) {
                    q.add(currNode.left);
                }
                if(currNode.right != null) {
                    q.add(currNode.right);
            }
        }
    }
}
 
    public static int countOfNodes(Node root){
        if(root==null){
            return 0;
        }
        int leftnodes= countOfNodes(root.left);
        int rightnodes= countOfNodes(root.right);

         return leftnodes+rightnodes+1;
    }

    public static int sumOfNodes(Node root){
        
        if(root==null){
            return 0;
        }
    
        int leftnodesum= sumOfNodes(root.left);
        int rightnodesum= sumOfNodes(root.right);
        
         return leftnodesum + rightnodesum + root.data;
    }

    public static int sumOfNodesAtk(Node root,int k){
        
        if(root==null){
            return 0;
        }
    
        int leftnodesum= sumOfNodes(root.left);
        int rightnodesum= sumOfNodes(root.right);
        
         return leftnodesum + rightnodesum + root.data;
    }



    public static int height(Node root){
        if (root==null){
            return 0;
        }
        int leftheight= height(root.left);
        int rightheight= height(root.right);

        int treehright= Math.max(leftheight, rightheight)+1;

        return treehright;
    }

    public static int diameter(Node root){
        if(root == null){
            return 0;
        }
        int diameterLS= diameter(root.left);
        int diameterRS= diameter(root.right);
        int diameteRoot= height(root.left)+height(root.right)+1;

        return Math.max(diameteRoot,Math.max(diameterLS,diameterRS));
    } 

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println("Root node:");
        System.out.println(root.data);
        System.out.println("preorder transversal:");
        preorder(root);
        System.out.println("");
        System.out.println("inorder transversal:");
        inorder(root);
        System.out.println("");
        System.out.println("postorder transversal:");
        postorder(root);
        System.out.println("");
        System.out.println("levelorder transversal:");
        levelorder(root);
        System.out.println("");
        System.out.println("Count of nodes: "+countOfNodes(root));
        System.out.println("");
        System.out.println("Sum of nodes: "+sumOfNodes(root));
        System.out.println("");
        System.out.println("Height of tree: "+height(root));
        System.out.println("");
        System.out.println("Diameter of a tree : "+diameter(root));
    }
}
