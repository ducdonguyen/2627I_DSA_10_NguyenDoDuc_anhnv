import java.io.*;
import java.util.*;

public class QuickSort {
  private static int partition(int[] arr, int low, int high){
    int pivot = arr[high];
    int i = low;
    for (int j = low; j < high; j++){
      if (arr[j] <= pivot){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        i += 1;
      }
    }
    int temp = arr[i];
    arr[i] = arr[high];
    arr[high] = temp;
    return i;
  }
  private static void printArray(int[] arr){
    for (int i: arr){
      System.out.print(i + " ");
    }
  }
  public static void quickSort(int[] arr, int low, int high){
    if (low < high){
      int id = partition(arr, low, high);

      printArray(arr);
      System.out.print("\n");

      quickSort(arr, low, id - 1);
      quickSort(arr, id + 1, high);
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(reader.readLine());
    String line  = reader.readLine();
    String tokens[] = line.trim().split("\\s+");
    int[] arr = new int[n];
    for (int i = 0; i < n; i++){
      arr[i] = Integer.parseInt(tokens[i]);
    }
    quickSort(arr, 0, arr.length - 1);
  }
}
