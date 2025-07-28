// Basically Tree are formed from nodes
//So we create a different class to store the data in the node
//As in family tree we know there is a root or the main person or 1st person in the family and all the members come below that in tree like structure.
//Similarly We are trying to create a tree of integers that consists of left subtree and right subtree and one main root
 class TreeNode {

    int data;
    TreeNode left;
    TreeNode right;


    //This is the constructor that is used to form TreeNode which ultimately helps in storing the int value in form of leaves or node of tree
    TreeNode(int data){
        this.data = data;

        //When a new node is added it has 0 children so left child and right child is initialised as null.
        this.left = null;
        this.right = null;
    }
}
