package step05;

public class Monitor {
  public static final int TF = 0;
  public static final int IPS = 1;
  protected String model;
  protected String maker;
  protected String resolution;
  protected int    type;
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
  public String getResolution() {
    return resolution;
  }
  public void setResolution(String resolution) {
    this.resolution = resolution;
  }
  public int getType() {
    return type;
  }
  public void setType(int type) {
    this.type = type;
  }
  @Override
  public String toString() {
    return "Monitor [model=" + model + ", maker=" + maker + ", resolution=" 
  + resolution + ", type=" + type + "]";
  }
  
}
