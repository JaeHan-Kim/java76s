/*
 * 주제 : 헤시맵 사용하기 (4)
 */
package step10.ex04;

import java.util.HashMap;

public class Test04 {
  
  static class MyKey {
    String id;
    int secNo;
    
    public MyKey (String id, int secNo) {
      this.id = id;
      this.secNo = secNo;
    }

    @Override
    public String toString() {
      return "MyKey [id=" + id + ", secNo=" + secNo + "]";
    }
    // Object로 부터 상속 받은 hashCode()는
    // 인스턴스 마다 고유의 해시 값을 리턴한다.
    //
    // 그러나 HasgMap의 키로 사용하려면,
    // 서로 다른 인승턴스라도 같은 데이러틀 갖고 있다면, 같은 해시 값을 리턴해야 한다.
    // 또한 equals()의 결과는 true여야 한다.
    // => hashcode()와 equals()를 오버라이딩 하라!
    // => 기존의 Wrapper클래스와 String 클래스는 이 메서드들은 오버라이딩을 했다.
    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((id == null) ? 0 : id.hashCode());
      result = prime * result + secNo;
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      MyKey other = (MyKey) obj;
      if (id == null) {
        if (other.id != null)
          return false;
      } else if (!id.equals(other.id))
        return false;
      if (secNo != other.secNo)
        return false;
      return true;
    }
    
  }
  public static void main(String[] args) {
    // 문자열을 사용 할 경우,
    String key1 = new String("aaa");
    String key2 = new String("bbb");
    String key3 = new String("ccc");
    
    HashMap map = new HashMap();
    map.put(key1, "임꺽정");
    map.put(key2, "김원봉");
    map.put(key3, "홍길동");

    System.out.println(map.get(key2));
    
    String key4 = new String("bbb");
    System.out.println(map.get(key4));
    System.out.println("-------------");
    
    // MyKey를 사용할 경우,
    MyKey mk1 = new MyKey("aaa", 10);
    MyKey mk2 = new MyKey("bbb", 20);
    MyKey mk3 = new MyKey("ccc", 30);
    MyKey mk4 = new MyKey("bbb", 20);

    HashMap map2 = new HashMap();
    map2.put(mk1, "떡볶이");
    map2.put(mk2, "족발");
    map2.put(mk3, "보쌈");
    
    System.out.println(map2.get(mk2));
    
    System.out.println(map2.get(new MyKey("bbb", 20))); // null 
    System.out.println("-------------");
  
    System.out.println(mk1.hashCode());
    System.out.println(mk2.hashCode());
    System.out.println(mk3.hashCode());
    System.out.println(mk4.hashCode());
    System.out.println("-------------");
    
    if (mk2 == mk4) {
      System.out.println("mk2 == mk4");
    }
    if (mk2.equals(mk4)) {
      System.out.println("mk2 == mk4");
    }
   
  }
}
