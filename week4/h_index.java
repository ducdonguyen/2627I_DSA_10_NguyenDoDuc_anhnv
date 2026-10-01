import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;

public class h_index {
  public static int evaluate(int[] arr){
    insertionSort(arr);
    int h = arr.length;
    for (int i = 0; i < arr.length; i++){
      if (arr[i] >= h) return h;
      h--;
    }
    return 0;
  }
  public static void insertionSort(int[] a){
    for (int i = 1; i < a.length; i++){
      int j = i - 1;
      boolean ok = false;
      int temp = a[i];
      while (j >= 0 && !ok){
        if (a[j] > temp){
          a[j+1] = a[j];
          j--;
        }
        else{
          ok = true;
        }
      }
      a[j+1] = temp;
    }
  }
  public static void main(String []args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(reader.readLine());
    String line = reader.readLine();
    String[] tokens = line.trim().split("\\s+");
    int[] arr = new int[tokens.length];
    for (int i = 0; i < tokens.length; i++){
      arr[i] = Integer.parseInt(tokens[i]);
    }
    System.out.println(evaluate(arr));
  }
}
