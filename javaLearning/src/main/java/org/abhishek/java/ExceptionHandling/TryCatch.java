package org.abhishek.java.ExceptionHandling;

public class TryCatch {

    public static void main(String[] args) {
        int arr [] = new int[5];
//
//        try {
//            int res = 5/0;  // it throws arthmaticeexceot
//            System.out.println(arr[9]);
//
//
//        }
//        catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println(" here error we found Array index out of bounds");
//        }
//        catch (ArithmeticException e){
//
//            System.out.println(e.getMessage());
//        }



        // i wanted handle both exceprtions in same way

//        try {
//            int res = 5/0;  // it throws arthmaticeexceot
//            System.out.println(arr[9]);
//
//
//        }
//        catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
//            System.out.println(" here error we found ");
//        }





        // i don't care which type of exception is occuring so i need only 1 message

        // note: Exception is parent class of all exceptions
        try {
            int res = 5/0;  // it throws arthmaticeexceot
            System.out.println(arr[9]);


        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }



        System.out.println(" hello world!");
    }
}
