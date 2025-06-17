package xyz;

import java.util.HashMap;

public class HashMap {

 public static void main(String[] args) {
  // TODO Auto-generated method stub
          HashMap< String,Integer> hs=new HashMap<>();
          hs.put( "carrot",10);
          hs.put( "tomato",20);
          hs.put( "beans",30);
          hs.put( "cabbage",50);
          hs.put( "beetroot",40);
          System.out.println(hs);
          int sum=0;
 for(int cost:hs.values()) {
  sum+=cost;
 }
 System.out.println(sum);
 System.out.println(hs.put("cabbage", 40));
 System.out.println(hs);
 System.out.println(hs.remove("beans", 30));
 System.out.println(hs);
 }
	

}