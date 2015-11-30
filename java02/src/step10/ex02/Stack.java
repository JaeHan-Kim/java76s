package step10.ex02;

public class Stack {
  private Object[] list = new Object[100];
  int pos;
  // 값을 맨 마지막에 넣는다.
  public int push(Object value) {
    if (pos >= list.length) {
      return -1;
    }
    else {
      list[pos++] = value;
      return 0;
    }
  }
  // 맨 마지막 값을 꺼낸다.(제거 한다)
  public Object pop() {
    
    if ((pos - 1) < 0) { 
      return -1;
    }
    return list[--pos];
  }
  // 맨 마지막 값을 꺼낸다. (제거하지 않는다.)
  public Object get() {
    if (pos > 0)
      return list[pos-1];
    else
      return list[0];
  }
  public int size(){
    return pos;
  }
  public static void main(String[] args) {
    Stack s = new Stack();
   
    System.out.println(s.push("0"));
    System.out.println(s.push("1"));
    System.out.println(s.push("2"));
    System.out.println(s.push("3"));

    int len = s.size();
    for (int i = 0; i < len; i++) {
      System.out.println(s.pop());
    }
  }
}
