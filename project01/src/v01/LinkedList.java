package v01;

// 1) 클래스 이름 뒤에 어떤 타입을 다룰 지 별명을 선언한다.
// 2) 그 타입을 사용하는 곳에 E 문자로 대체하라
public class LinkedList<E> {
  private Bucket<E> start;
  private Bucket<E> end;
  private int length;
  
  public LinkedList() {
    start = new Bucket<E>();
    end = start;
  }
  
  public int add(E value) {
    end.setValue(value);
    end.setNext(new Bucket<E>());
    end = end.getNext();
    length++;
    return 0;
  }

  public E get(int index) {
    if (index < 0 || index >= length) {
      return null;
    }
    int pos = 0; 
    Bucket<E> cursor = start;
    while (pos < index) {
      cursor = cursor.getNext();
      pos++;
    }
    return cursor.getValue();
  }
  public E remove(int index) {
    if (index < 0 || index >= length) {
      return null;
    }
    E removedValue = null;
    length--;
    
    if (index == 0) {
      removedValue = start.getValue();
      return removedValue;
    }
    int pos = 0;
    Bucket<E> cursor = start;
    while (pos < (index - 1)) {
      cursor = cursor.getNext();
      pos++;
    }
    
    removedValue = cursor.getNext().getValue();
    cursor.setNext(cursor.getNext().getNext());
    
    return removedValue;
  }
  public int size() {
    return length;
  }
  public Object insert(int index) {
    Bucket<E> cursor = start;
    if (index == 0) {
      
    }
    return null;
  }
  public static void main(String[] args) {
    LinkedList<String> list = new LinkedList<String>();
    list.add("0000");
    list.add("1111");
    list.add("2222");
    list.add("3333");
    list.add("4444");
    list.add("5555");
 //   list.add(1000);
    String item;
    for (int i = 0; i < list.size()-1; i++) {
      item = list.get(i);
    }
}
}
