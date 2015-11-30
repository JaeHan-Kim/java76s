package step13.ex04;

public class Test01 {
  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.add("0000");
    list.add("1111");
    list.add("2222");
    list.add("3333");
    list.add("4444");
    list.add("5555");

    EvenIterator iterator = new EvenIterator(list);
    
    while(iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}
