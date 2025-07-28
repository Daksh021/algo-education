import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_Array {

    static int [] array;
    static int size;
    static Scanner sc = new Scanner(System.in);

    //We are defining here the root of the tree so as a new node is created so it has no children so it acts as a root
    static TreeNode root;


    //To form the array using user's input
    public static void makingOfArray(int size){

        array = new int[size];

        System.out.println("Give Input elements ");
        for(int i = 0; i < size; i++){

            //Taking user Input to form user desired array

            array[i] = sc.nextInt();
        }

        System.out.println("Array formed");
        System.out.println();
        System.out.println("View Your Resultant array");

        for(int i = 0; i < size; i++){
            System.out.print(array[i] + " ");
        }

    }


    //To form a normal tree using array
    public static TreeNode makingTree(int [] array , int start , int end){

        //While making a tree from a array we always make the middle element as root and move recursively to left and right
        //To find middle element of the array we take start and end pointer and put the formula start + (end - start)/ 2 t0 fetch middle element.
        //Now you might be thinking why not (start + end) / 2
        //This formula is considered safe to avoid overflow in arrays with larger value
        // EX : -
//        int start = 2_000_000_000;
//        int end = 2_100_000_000;
//        Using (start + end) / 2 = (4_100_000_000) / 2 causes overflow for datatype int.


        if(start > end) return null;
       int middle = start + (end - start)/ 2;
       TreeNode root = new TreeNode(array[middle]);

        // We are recursively calling the function to form left and right subtree
       root.left = makingTree(array,start,middle-1);
       root.right = makingTree(array,middle+1,end);

       return root;
    }

    //To form a Binary Search Tree
    public static TreeNode makingBinarySearchTree(int [] array,int start, int end){

        //While making a tree from a array we always make the middle element as root and move recursively to left and right
        //To find middle element of the array we take start and end pointer and put the formula start + (end - start)/ 2 t0 fetch middle element.
        //Now you might be thinking why not (start + end) / 2
        //This formula is considered safe to avoid overflow in arrays with larger value
        // EX : -
//        int start = 2_000_000_000;
//        int end = 2_100_000_000;
//        Using (start + end) / 2 = (4_100_000_000) / 2 causes overflow for datatype int.



        if(start > end) return null;
        int middle = start + (end - start) / 2;
        TreeNode root = new TreeNode(array[middle]);

        // We are recursively calling the function to form left and right subtree
        root.left = makingBinarySearchTree(array,start,middle - 1);
        root.right = makingBinarySearchTree(array,middle + 1 , end);
        return root;
    }

    //Using BFS - Breadth First Search
    public static void showTree(TreeNode root){

        //As java is prone to null pointer errors
        // For safer side we first check if root = null if yes dont execute the code and exit the function
        if(root == null) {
            System.out.println("Root is null so no tree present");
            return;
        }

        //We use queue Data structure to traverse the tree it first explores the neighbour nodes ie left and right
        // Then add it to queue we do it until the whole nodes in the tree is covered till the last node present in the last level.
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){

            TreeNode currentNode = queue.remove();
            System.out.print(currentNode.data + " ");

            //We are checking for null values and avoiding null pointer exception.
            if(currentNode.left != null){
                queue.add(currentNode.left);
            }

            //We are checking for null values and avoiding null pointer exception.
            if(currentNode.right != null){
                queue.add(currentNode.right);
            }
        }
    }


    public static void main(String[] args) {
        System.out.println("Input  the size of the array you want");
        size = sc.nextInt();

        //To form the array call this method
        System.out.println("Calling the function to make the array");
        makingOfArray(size);

        System.out.println();
        System.out.println("Enter the choice of tree you want");
        System.out.println("1 is for normal tree and 2 is for Binary Search Tree");
        int choice = sc.nextInt();

        switch (choice){

            case 1: root = makingTree(array,0,array.length - 1);
            break;
            case 2:
                // For formation of Binary Search Tree we first sort the array
                //Reason in Binary Search Tree the root value is present.
                //All the values less than root are added to the left of the tree.
                //All the values greater than root are added to right of the tree.
                //So we sort the array so that as the root is middle element in array
                //All the elements left to middle are less than middle will be present in left subtree
                //All the elements right to the middle are greater than the middle element are added in th right subtree
                // It satisfies the Binary Search tree Property.

                Arrays.sort(array);
                root = makingBinarySearchTree(array,0,array.length - 1);
            break;
            default:
                System.out.println("You entered wrong value");
                break;
        }

        System.out.println("Tree Formed");

        System.out.println("Printing the tree using Breadth First Search");
        showTree(root);

    }
}
