package step07.ex15;

public class Customer2 {
  private String  name;
  private boolean gender;
  private int     age;
  private float   height;
  private float   weight;
  private float   fatRate;
  @Override
  public String toString() {
    return "Customer [name=" + name + ", gender=" + gender + ", age=" 
                      + age + ", height=" + height + ", weight="
                      + weight + ", fatRate=" + fatRate + "]";
  }
  // 인스턴스의 값을 넣는 메서드 제공
  // => set으로 메서드 이름을 시작한다.
  // => 셋터(setter) 메서드라 부른다.
  public void setName(String name) {
    if (name == null)
      this.name = "홍길동";
    else
      this.name = name;
  }
  public void setGender(boolean gender) {
    this.gender = gender;
  }
  public void setAge(int age) {
    if (age >=10 && age <= 90)
      this.age = age;
    else
      this.age = 30;
  } 
  public void setHeight(float height) {
    if (height >=100 && height <= 290)
      this.height = height;
    else
      this.height = 170;
    
  }
  public void setWeight(float weight) {
    if (weight >=10 && weight <= 90)
      this.weight = weight;
    else
      this.height = 65;
    
  }
  public void setFatRate(float fatRate) {
    if (fatRate > 0 && weight < 70)
      this.fatRate = fatRate;
    else
      this.fatRate = 25;    
  }
  public String getName() {
    return name;
  }
  public boolean isGender() {
    return gender;
  }
  public int getAge() {
    return age;
  }
  public float getHeight() {
    return height;
  }
  public float getWeight() {
    return weight;
  }
  public float getFatRate() {
    return fatRate;
  }

}
