package step13.ex03;

public class LinkedList {
  public void m1() {
    this.size();
  }

  private static class Bucket {
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

  // Member Inner Class
  // => 일반적인 메서드와 동일하게 바깥 클래스의 인스턴스 변수나 인스턴스 메서드를 사용할 수 있다.
  public class Iterator {
    int cursor;

    public boolean hasNext() {
      // 안에서는 바깥을 볼 수 있다.
      // 멤버 이너 클래스는 바깥 클래스의 멤버(인스턴스 변수와 인스턴스 메서드)를 사용할 수 있다.
      if (cursor < /*LinkedList.this.*/size())
          return true;
      return false;
    }
    public Object next() {
      int i = cursor;
      cursor += 2;
      return /*LinkedList.this.*/get(i);

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
  
  // Iterator 객체를 리턴할 메서드를 준비한다.
  public Iterator iterator() {
    // 다음과 같이 새로 만든 Iterator 객체는,
    // 자신을 생성한 바깥 객체(LinkedList 객체)의 주소를 알고 있다.
    return new Iterator();
  }
}
