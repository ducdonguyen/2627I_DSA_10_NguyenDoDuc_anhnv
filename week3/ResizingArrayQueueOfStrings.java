public class ResizingArrayQueueOfStrings {
  private static String[] q = new String[2];
  private static int n = 0;
  private static int head = 0;
  private static int tail = 0;
  private static void resize(int capacity){
    String[] temp = new String[capacity];
    for (int i = 0; i < q.length; i++){
      temp[i] = q[(head + i) % q.length];
    }
    q = temp;
    head = 0;
    tail = n;
  }
  public static void enqueue(String item){
    if (n == q.length) resize(n * 2);
    q[tail] = item;
    tail = (tail + 1) % q.length;
    n++;
  }
  public static String dequeue(){
    String item = q[head];
    q[head] = null;
    head = (head + 1) % q.length;
    n--;
    if (n > 0 && n == q.length/4) resize(q.length/2);
    return item;
  }
}
