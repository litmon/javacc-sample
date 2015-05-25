class Sample{
  public static void main(String[] args){
    Sample s = new Sample();

    System.out.println("getA(): " + s.getA());
    System.out.println("innerClass.getA(): " + s.getInnerA.getA());
  }

  private int a = 1;
  private InnerClass innerA = new InnerClass(10);
  
  public int getA(){
    return a;
  }

  public InnerClass getInnerA(){
    return innerA;
  }

  public class InnerClass{
    public int a;

    public InnerClass(int a){
      this.a = a;
    }

    public static getA(){
      return a;
    }
  }
}
