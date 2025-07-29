// Detailed Explanation to Linear search Algorithm
// Real life example of linear search is looking your name in attendance sheet or marks list.
//As you see from top to bottom each and every name in attendance sheet or marks list till you find your name.
// This is the simplest example I can come up with it

import java.util.Scanner;

public class LinearSearch {

    public static void linearSearch(int [] array , int target){

        //I am putting a for loop to see elements one by one and compare them to target
        for(int i = 0; i < array.length; i++){

            //If the current element is equal to target print the target and its location in 0 based index
            if(array[i] == target){
                System.out.println("target : " + target + " found " + "at index : " + i );
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the size of the array");
        int size = sc.nextInt();

        int [] array = new int[size];

        for(int i = 0; i < size; i++){
            array[i] = sc.nextInt();
        }

        System.out.println("View your resultant array ");
        for(int i = 0; i < size; i++){
            System.out.print(array[i] + " ");
        }

        System.out.println();

        System.out.println("Input the element you want to search for ");
        int target = sc.nextInt();

        //In array the index does not start from 1 it starts from 0
        /*
        EX - [1,2,3,4,5]
        So naturally if I ask tell me the index where 3 is present then mostly people say at index 3
        because they start counting from 1 but in programming languages we start counting from 0.
        So the answer to my question will be 2
        1 is present at index 0
        2 is present at index 1
        3 is present at index 2

        So final answer will be 2
         */
        System.out.println("Calling linear search function to fetch the location of target in 0 based index array");
        linearSearch(array,target);
    }
}
