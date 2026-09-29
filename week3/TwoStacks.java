import java.io.*;
import java.util.*;

public class TwoStacks {
  static Stack<String> s1 = new Stack<>();
  static Stack<String> s2 = new Stack<>();
  public static void enqueue(String x){
    s1.push(x);
  }
  private static void shift(){
    if (!s2.isEmpty()) return;
    else{
      while (!s1.isEmpty()){
        s2.push(s1.pop());
      }
    }
  }
  public static void dequeue(){
    shift();
    s2.pop();
  }
  public static void print(){
    shift();
    System.out.println(s2.peek());
  }
  public static void main(String args[]){
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while (true) {
      try {
        if (!((line = reader.readLine()) != null)) break;
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
      String[] tokens = line.trim().split("\\s+");
      if (tokens[0].equals("1")) enqueue(tokens[1]);
      else if (tokens[0].equals("2")) dequeue();
      else if (tokens[0].equals("3")) print();
    }
  }
}
