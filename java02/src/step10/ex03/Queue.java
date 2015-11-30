package step10.ex03;

import step10.ex01.Bucket;

public class Queue {
  private Object[] list = new Object[100];
  Bucket front;
  Bucket rear;
  int length;
  
  public Queue() {
    front = new Bucket();
    rear = front;
  }
  public int put(Object value) {
    rear.setValue(value);
    rear.setNext(new Bucket());
    rear = rear.getNext();
    length++;
    return 0;
  }
  public Object get() {
    
    front = front.getNext();
    return front.getValue();
  }
  public int size() {
    return length;
  }
  public static void main(String[] args) {
    Queue list = new Queue();
    list.put("1");
    list.put("2");
    System.out.println(list.get());
    System.out.println(list.get());
    
    //for (int i = 0; i < list.size(); i++) {
    //  System.out.println(list.get());
    //}
  }
}
