import edu.princeton.cs.algs4.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kth {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int k = Integer.parseInt(reader.readLine());
    Queue<String> q = new Queue<>();
    String cur = reader.readLine();
    String[] tokens = cur.split("\\s+");
    for (String s: tokens){
      q.enqueue(s);
      if (q.size() > k) q.dequeue();
    }
    System.out.println(q.dequeue());
  }
}
