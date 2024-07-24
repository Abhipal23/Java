package org.abhishek.java.ExceptionHandling;

public class FinallyBlocks {

    public static void main(String[] args) {

        int arr []= new int[6];

        System.out.println("hello world!");

        try {
            System.out.println(arr[3]);

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("finally block!");
        }
    }
}
