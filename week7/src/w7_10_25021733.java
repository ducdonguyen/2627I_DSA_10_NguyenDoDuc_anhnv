import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'runningMedian' function below.
   *
   * The function is expected to return a DOUBLE_ARRAY.
   * The function accepts INTEGER_ARRAY a as parameter.
   */

  public static List<Double> runningMedian(List<Integer> a) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    List<Double> result = new ArrayList<>();

    for (int x : a) {
      if (maxHeap.isEmpty() || x <= maxHeap.peek()) {
        maxHeap.offer(x);
      } else {
        minHeap.offer(x);
      }

      if (maxHeap.size() > minHeap.size() + 1) {
        minHeap.offer(maxHeap.poll());
      } else if (minHeap.size() > maxHeap.size()) {
        maxHeap.offer(minHeap.poll());
      }

      if (maxHeap.size() > minHeap.size()) {
        result.add((double) maxHeap.peek());
      } else {
        result.add((double) (maxHeap.peek() + minHeap.peek()) / 2.0);
      }
    }

    return result;

  }

}

public class w7_10_25021733 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int aCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
              try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

    List<Double> result = Result.runningMedian(a);

    bufferedWriter.write(
            result.stream()
                    .map(Object::toString)
                    .collect(joining("\n"))
                    + "\n"
    );

    bufferedReader.close();
    bufferedWriter.close();
  }
}
