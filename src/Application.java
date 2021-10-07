import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Application {

    //This main class has the user interface and it will create a object from the file text class to return String into the binary object

    public static void main(String[] args) {

        //Variables
        Boolean run = true;

        //Get absolute path for any device it runs on
        String file = "Poem.txt";
        File getabsolute = new File(file);

        BinaryTreeLinkedList binaryList = new BinaryTreeLinkedList();
        String absolute = getabsolute.getAbsolutePath();
        FileRead reader = new FileRead(absolute);
        BinaryNode node = new BinaryNode();
        Scanner input = new Scanner(System.in);

        //Fill BinaryTree
        int i = 0;
        while(i < reader.getSize()){
            binaryList.insert(reader.getText(i));
            i++;
        }

        while(run){

            switch(displayOptions()){

                case '1':{
                    binaryList.inOrder(binaryList.getRoot());
                    break;
                }

                case '2':{

                    binaryList.preOrder(binaryList.getRoot());
                    break;
                }

                case '3':{

                    binaryList.postOrder(binaryList.getRoot());
                    break;
                }

                case '4':{

                    binaryList.levelOrder();
                    break;
                }

                case '5':{
                    System.out.print("Enter word to search: ");
                    String searchword = input.nextLine();
                    binaryList.search(searchword);
                    break;
                }

                case '6':{
                    run = false; //Stop Program
                    break;
                }

                default:{
                    System.err.println("Please Enter Option Above!");
                }
            }
            promptEnterKey(); //Pause after task
        }
    }

    public static void promptEnterKey(){
        System.out.println("\n\nPress \"ENTER\" to continue...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static char displayOptions(){

        Scanner scanner = new Scanner(System.in);
        System.out.print(
                "Please Select Option Below By Entering Corresponding Number:\n\n" +
                        "1) Show in-order Binary Tree\n" +
                        "2) Show pre-order Binary Tree\n" +
                        "3) Show post-order Binary Tree\n" +
                        "4) Show level-order Binary Tree\n" +
                        "5) Search for word\n" +
                        "6) Exit System\n\nEnter Option Here: ");

        char option = scanner.next().charAt(0);
        return option;
    }
}

