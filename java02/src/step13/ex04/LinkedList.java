package step13.ex04;

public class LinkedList {

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
  
}
