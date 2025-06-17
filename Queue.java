package xyz;

import java.util.LinkedList;
import java.util.Queue;

public class Queue {

 public static void main(String[] args) {
  // TODO Auto-generated method stub
       Queue<String> shop=new LinkedList<>();
       shop.add("child 1");
       shop.add("child 2");
       shop.add("child 3");
       shop.add("child 4");
       shop.add("child 5");
       System.out.println(shop.peek());
       System.out.println(shop.poll());
       shop.add("child 6");
       System.out.println(shop);
 }

}