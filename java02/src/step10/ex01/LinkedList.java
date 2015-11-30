package step10.ex01;

public class LinkedList {
  // Bucket 클래스는 LinkedLsit에서만 사용하는 클래스이기 때문에,
  // 이런 경우 중첩 클래스로 정의하는 것이 가장 바람직하다.
  public class Bucket {
    protected Object value;
    protected Bucket next;
    
    public Bucket() {}
    
    public Bucket(Object value) {
      this.value = value;
    }
    
    public Bucket(Object value, Bucket next) {
      this.value = value;
      this.next = next;
    }

    public Object getValue() {
      return value;
    }

    public void setValue(Object value) {
      this.value = value;
    }

    public Bucket getNext() {
      return next;
    }

    public void setNext(Bucket next) {
      this.next = next;
    }
    
  }
  
  private Bucket start;
  private Bucket end;
  private int length;
  
  public LinkedList() {
    start = new Bucket();
    end = start;
  }
  
  public int add(Object value) {
    end.setValue(value);
    end.setNext(new Bucket());
    end = end.getNext();
    length++;
    return 0;
  }

  public Object get(int index) {
    if (index < 0 || index >= length) {
      return null;
    }
    int pos = 0; 
    Bucket cursor = start;
    while (pos < index) {
      cursor = cursor.getNext();
      pos++;
    }
    return cursor.getValue();
  }
  public Object remove(int index) {
    if (index < 0 || index >= length) {
      return null;
    }
    Object removedValue = null;
    length--;
    
    if (index == 0) {
      removedValue = start.getNext();
      return removedValue;
    }
    int pos = 0;
    Bucket cursor = start;
    while (pos < (index - 1)) {
      cursor = cursor.getNext();
      pos++;
    }
    
    removedValue = cursor.getNext().getNext();
    cursor.setNext(cursor.getNext().getNext());
    
    return removedValue;
  }
  public int size() {
    return length;
  }
  public Object insert(int index) {
    Bucket cursor = start;
    if (index == 0) {
      
    }
    return null;
  }
  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.add("0000");
    list.add("1111");
    list.add("2222");
    list.add("3333");
    list.add("4444");
    list.add("5555");
    for (int i = 0; i < list.size()-1; i++) {
      System.out.println(list.get(i));
    }
    System.out.println("------------------");
  list.remove(1);
/*    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }
  */  
}
}
