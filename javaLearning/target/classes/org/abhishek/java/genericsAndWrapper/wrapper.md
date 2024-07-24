# Wrapper class:
   wrapper class in java is class whose object is wraps or contain primitive data types.
   when we create object to a wrapper class,it contains a filed and in this filed we can store primitive data types.

| Primitive data types | Wrapper class |
|----------------------|---------------|
| int                  | Integer       |
| char                 | Character     |
| byte                 | Byte          |
 | 

```java
        class Integer{
            int data ;
        }
        
        // in the wrapper class it contain a filed which will store primitive data 

// these wrapper class is available in jdk
```

# Need of wrapper class 
   
    1.classes in java.util package handle only object and hence wrapper class helps in this 

    2.DataStructure in collection framework such as ArrayList and Vector store only object. ( reference  types) not primitive types
    3.An object is needed in synchronizing in multithreading 



# AutoBoxing and Unboxing
    1: Automatic conversion of primitive data type to its corresponding wrapper class is known as AutoBoxing 
     ex: int->Integer,long ->Long ...

    2:Unboxing : reverse of AutoBoxing : conversion of object of  wrapper class  to corresponding primitive data type


```java
           public  class WrapperClass{
          public static void main(String[] args) {
              
              // we will create object of Integer wrapper class
               // Integer obj = new Integer(10);  // not in use now 
              
              // another way 
              
              Integer obj1 = Integer.valueOf(23);
              
              // or 
              Integer obj2 =23;  // this called autoboxing
              
              
              int age = obj2;   // unboxing 
        
    }
}
```