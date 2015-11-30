package step12.ex01;

import java.io.FileInputStream;
import java.util.Properties;

public class Test01 {
  public static void main(String[] args) throws Exception {


    // step120ex01 패키지에 있는 test.properties읽기
    Properties props = new Properties();
    props.load (new FileInputStream("src/step12/ex01/test.properties"));

    System.out.println(props.getProperty("s01"));
    System.out.println(props.getProperty("s02"));
    System.out.println(props.getProperty("s03"));

    // 키를 모를 때 값 꺼내기
    // 1) key 목록을 얻는다.
    // 2) 반복문을 사용하여 각 key의 value를 꺼낸다.
    for(Object value : props.keySet()) {
      System.out.printf("%s = %s\n", 
          value, 
          props.getProperty((String)value));
    }
  }

}
