import java.io.*;

class Parse{

  public static void main(String[] args){
    System.out.println("Hello Java");
    
    Logger logger = new Logger();

    try{
      logger.start("Parse Sample.java");

    }finally{
      logger.finish();
    }
  }

}

class Logger{

  public State state = State.IDLE;
  public String logName;

  public void print(String content){
    if(state == State.LOGGING){
      System.out.println(System.currentTimeMills() + ": " + content);  
    }else{
      throw new IllegalStateException("You should call Logger#start before calling Logger#print");
    }
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
    if(state == State.IDLE){
      state = State.LOGGING;
    }else if(state == State.LOGGING){
      state = State.IDLE;
    }
  }

  public void setLogName(String logName){
    this.logName = logName;
  }

  public enum State{
    IDLE, LOGGING;
  }

}
