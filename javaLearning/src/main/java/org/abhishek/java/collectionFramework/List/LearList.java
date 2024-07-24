package org.abhishek.java.collectionFramework.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LearList {
    public static void main(String[] args) {
        List<Integer> list  = new ArrayList<>();
        // ArrayList are dynamic in size

       // list in an Inteface and Arraylist is implememtation class of List

        list.add(10);
        list.add(20);
    //   add(E data): add data at last
        System.out.println(list);


        // list iterator

        List<String> userName = new ArrayList<>();
        userName.add("Abhishek");
        userName.add("gautam");
        userName.add("ram");
        userName.add("Shyam");


        // ways to iterate in a list

        // 1: using traditional for loop
//        for(int i =0; i<userName.size(); i++)
//               System.out.println(userName.get(i));

//        for(String user:userName) System.out.println(user);

        // using iterator
//
//        Iterator<String> userIterator = userName.iterator();
//        while(userIterator.hasNext()) {
//            System.out.println(userIterator.next());
//        }

        // get subList

        List<String> subUserName = userName.subList(0, 3);
           System.out.println(subUserName); 


    }
}
