import edu.princeton.cs.algs4.*;
public class TimeEvaluation {
  public static void insertionSort(int[] a, int n){
    for (int i = 1; i < n; i++){
      int j = i - 1;
      boolean ok = false;
      int temp = a[i];
      while (j >= 1 && !ok){
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

  public static void selectionSort(int[] a, int n){
    for (int i = 0; i < n; i++){
      int min = a[i];
      int index = i;
      for (int j = i + 1; j < n; j++){
        if (min > a[j]){
          min = a[j];
          index = j;
        }
      }
      int tmp = a[i];
      a[i] = a[index];
      a[index] = tmp;
    }
  }

  public static void main(String[] args){
    In in = new In("data\\1Mints.txt");
    int[] arr = in.readAllInts();
    long start = System.currentTimeMillis();
    insertionSort(arr, 1000000);
    long end = System.currentTimeMillis();
    System.out.println(end - start);
  }
}
