import java.io.*;

class Parse{

  public static void main(String[] args){
    System.out.println("Hello Java");
    
    Logger logger = new Logger();

    try{
      logger.start("Parse Sample.java");

      BufferedReader br = readFile("Sample.java");


      br.close();
    }catch(Exception e){
      e.printStackTrace();
    }finally{
      logger.finish();
    }
  }

  public static BufferedReader readFile(String fileName) throw FileNotFoundException {
    return new BufferedReader(new FileReader(new File("Sample.java")));
  }

}

class Logger{

  public State state = State.IDLE;
  public String logName;

  public void print(String content){
    if(state == State.LOGGING){
      System.out.println(System.currentTimeMillis() + ": " + content);  
    }else{
      throw new IllegalStateException("You should call Logger#start before calling Logger#print");
    }
  }

  public boolean isLogging(){
    return state == State.LOGGING;
  }

  public void start(String logName){
    setLogName(logName);
    nextState();

    System.out.println("======= Logging Started: " + logName + "=======");
  }

  public void finish(){
    nextState();
    System.out.println("======= Logging finished: " + logName + "=======");
  }

  public void nextState(){
    if(isLogging()){
      state = State.IDLE;
    }else{
      state = State.LOGGING;
    }
  }

  public void setLogName(String logName){
    this.logName = logName;
  }

  public enum State{
    IDLE, LOGGING;
  }

}
