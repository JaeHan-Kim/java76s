package v06;

import java.util.Scanner;

public abstract class MenuControl {
  protected Scanner scanner;
  
  public MenuControl(){}
  public MenuControl(Scanner scanner) {
    this.scanner = scanner;
  }
  // service() 메서드는 어차피 하위 클래스에서 재정의해야만 하는 메서드이다.
  // => 굳이 구현할 필요가 있나요?
  // => 하위 클래스에서 반드시 구현해야 하는 메서드 아닌가요?
  //    하위 클래스가 반드시 구현하도록 강제할 방법은 없나요?
  public abstract void service(); // 추상 메서드는 구현할 수 없다.
  
  public Scanner getScanner() {
    return scanner;
  }

  public void setScanner(Scanner scanner) {
    this.scanner = scanner;
  }

}
