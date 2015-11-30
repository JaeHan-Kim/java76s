package step08;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

public class Computer {
  protected String  model;
  protected String  maker;
  protected int     ram;
  protected float   speed;
  protected Monitor monitor;
  protected HDD storage;
  protected Map<String, String> specs;

  public Computer() {}
  
  public Computer(String model, int ram) {
    System.out.println("Computer(String, int)");
    this.model = model;
    this.ram = ram;
  }
  
  public Computer(int ram, String maker) {
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
  @Autowired
  public void setMonitor(Monitor monitor) {
    System.out.println("setMonitor()");
    this.monitor = monitor;
  }

  public HDD getStorage() {
    return storage;
  }
  @Autowired
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
