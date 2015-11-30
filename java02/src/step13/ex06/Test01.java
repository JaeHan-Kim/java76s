package step13.ex06;

public class Test01 {
  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.add("0000");
    list.add("1111");
    list.add("2222");
    list.add("3333");
    list.add("4444");
    list.add("5555");

    LinkedList.AbstractIterator iterator = list.iterator("a");
    
    while(iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}
