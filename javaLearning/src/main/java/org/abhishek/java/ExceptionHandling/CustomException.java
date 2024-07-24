package org.abhishek.java.ExceptionHandling;

import java.util.Scanner;

public class CustomException {

    public  static  void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter age ");

        try {
            int age = sc.nextInt();
            if (age > 100) {
                throw new MyException("my exception");
            }
        }

        catch (Exception e){
            System.out.println(e);


        }



    }


    }
    class  MyException extends Exception {
        public MyException(String message) {
            super(message);
        }


     }

