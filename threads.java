package xyz;
class car extends Thread{
 public void run() {
  for(int i=1;i<=3;i++) {
  System.out.println("car moving"+i);
  try {
   Thread.sleep(500);
  } catch (Exception e) {
   // TODO: handle exception
  }
 }
 }
}
class Bike extends Thread {
 public void run() {
  for(int i=1;i<=3;i++) {
  System.out.println("bike moving"+i);
  try {
   Thread.sleep(500);
  } catch (Exception e) {
   // TODO: handle exception
  }
 }
 }
}
public class threads {

 public static void main(String[] args) {
  // TODO Auto-generated method stub
  car c=new car();
  Bike b=new Bike();
  c.start();
  b.start();
 }

}
