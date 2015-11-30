package step08;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

public class Computer5 {
  protected String  model;
  protected String  maker;
  protected int     ram;
  protected float   speed;
  @Resource(name="m1") // 기본은 필수 항목이다. => 주입할 객체가 없으면 오류가 발생한다.
  protected Monitor monitor;
  @Autowired protected HDD storage;
  protected Map<String, String> specs;

  public Computer5() {}
  
  public Computer5(String model, int ram) {
    System.out.println("Computer(String, int)");
    this.model = model;
    this.ram = ram;
  }
  
  public Computer5(int ram, String maker) {
    System.out.println("Computer(int, String)");
    this.ram = ram;
    this.maker = maker;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getMaker() {
    return maker;
  }

  public void setMaker(String maker) {
    this.maker = maker;
  }

  public int getRam() {
    return ram;
  }

  public void setRam(int ram) {
    this.ram = ram;
  }

  public float getSpeed() {
    return speed;
  }

  public void setSpeed(float speed) {
    this.speed = speed;
  }

  public Monitor getMonitor() {
    return monitor;
  }
  public void setMonitor(Monitor monitor) {
    System.out.println("setMonitor()");
    this.monitor = monitor;
  }

  public HDD getStorage() {
    return storage;
  }
  public void setStorage(HDD storage) {
    System.out.println("setStorage()");
    this.storage = storage;
  }

  public Map<String, String> getSpecs() {
    return specs;
  }

  public void setSpecs(Map<String, String> specs) {
    this.specs = specs;
  }

  @Override
  public String toString() {
    return "Computer [model=" + model + ", maker=" + maker + ", ram=" + ram + 
           ", speed=" + speed + ", monitor="
           + monitor + ", storage=" + storage + ", specs=" + specs + "]";
  }

}
