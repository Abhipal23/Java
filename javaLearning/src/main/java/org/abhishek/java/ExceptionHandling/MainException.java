package org.abhishek.java.ExceptionHandling;

public class MainException {

    public static void main(String[] args) {
        int arr[] = new int [5];
        // i have created an array of size 5 now i will try to access 8th element

        System.out.println(arr[8]);
        // this will throw an exception
//        Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 8 out of bounds for length 5
//        at org.abhishek.java.ExceptionHandling.MainException.main(MainException.java:9)




        System.out.println("hello ");
        // this line won't be execute as exception occurs above

    }
}
