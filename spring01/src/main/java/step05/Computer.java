package step05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class Computer {
  protected String  model;
  protected String  maker;
  protected int     ram;
  protected float   speed;
  protected ArrayList<Monitor> monitor;
  protected String[] Options;
  protected Set<HDD> storage;
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

  public ArrayList<Monitor> getMonitor() {
    return monitor;
  }

  public void setMonitor(ArrayList<Monitor> monitor) {
    this.monitor = monitor;
  }

  public String[] getOptions() {
    return Options;
  }

  public void setOptions(String[] options) {
    Options = options;
  }

  public Set<HDD> getStorage() {
    return storage;
  }

  public void setStorage(Set<HDD> storage) {
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
    return "Computer [model=" + model + ", maker=" + maker + ", ram=" + ram + ", speed=" + speed + ", monitor="
        + monitor + ", Options=" + Arrays.toString(Options) + ", storage=" + storage + ", specs=" + specs + "]";
  }

  

}
