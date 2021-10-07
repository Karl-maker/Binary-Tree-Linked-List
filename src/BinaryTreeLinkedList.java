
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLinkedList {

    private BinaryNode root;

    public BinaryTreeLinkedList(){

        this.root = null;

    }

    public BinaryNode getRoot(){
        return root;
    }

    public void search(String word){
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        int num = 0;
        ArrayList<Integer> heights = new ArrayList<>();

        while(!queue.isEmpty()){
            BinaryNode presentNode = queue.remove();
            //Check if ==
            if(presentNode.getValue().equalsIgnoreCase(word)){
                num++;
                heights.add(presentNode.getLevel());

            }

            if(presentNode.getLeft() != null){
                queue.add(presentNode.getLeft());
            }
            if(presentNode.getRight() != null){
                queue.add(presentNode.getRight());
            }
        }
        if(num == 0){
            System.out.println("Word was not found in file"); //If String isn't in poem
        }
        else{
            System.out.print("The word " + word + " was found " +num+ " times in BinaryTree levels of ");
            int i = 0;
            while(i < heights.size()){
                System.out.print(heights.get(i) + " ");
                i++;
            }
            System.out.println("");
        }
    }

    public void preOrder(BinaryNode node){
        if(node == null)
            return;
        System.out.print(node.getValue() + " ");
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    public void inOrder(BinaryNode node){

        if(node == null)
            return;
        inOrder(node.getLeft());
        System.out.print(node.getValue() + " ");
        inOrder(node.getRight());
    }

    public void postOrder(BinaryNode node){

        if(node == null)
            return;
        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.print(node.getValue() + " ");
    }

    public void levelOrder(){

        if (root == null){
            System.out.println("Error, No Data Found");
        }

        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);

        while(!queue.isEmpty()){
            BinaryNode presentNode = queue.remove();
            System.out.print(presentNode.getValue() + " ");

            if(presentNode.getLeft() != null){
                queue.add(presentNode.getLeft());
            }
            if(presentNode.getRight() != null){
                queue.add(presentNode.getRight());
            }
        }
    }

    public void insert(String value){
        BinaryNode node = new BinaryNode();
        node.setValue(value);


            if (root == null) {
                root = node;
                return;

            }
            Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
            queue.add(root);

            int loopnum = 1;
            int check = 0;
            loopnum++;
            int level = (int)(Math.log(loopnum) / Math.log(2));
            while (!queue.isEmpty()) {
                BinaryNode presentNode = queue.remove();



                if (presentNode.getLeft() == null) {
                    presentNode.setLeft(node);
                    presentNode.getLeft().setLevel(level);
                    return;
                } else if (presentNode.getRight() == null) {
                    presentNode.setRight(node);
                    presentNode.getRight().setLevel(level);
                    return;
                } else {
                    queue.add(presentNode.getLeft());
                    queue.add(presentNode.getRight());

                }
            }
    }
}
