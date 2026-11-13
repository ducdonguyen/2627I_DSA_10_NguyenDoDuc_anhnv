import java.awt.geom.RectangularShape;

public class DivideAndConquer {
  static class Result{
    int min;
    int max;
    public Result(int min, int max){
      this.min = min;
      this.max = max;
    }
  }

  public static Result MaxMin(int[] arr, int i, int j){
    if (i == j){
      return new Result(arr[i], arr[j]);
    }
    if (j == i + 1){
      if (arr[i] < arr[j]){
        return new Result(arr[i], arr[j]);
      }
      else{
        return new Result(arr[j], arr[i]);
      }
    }
    int piv = (i + j) / 2;
    Result resl = MaxMin(arr, i, piv);
    Result resr = MaxMin(arr, piv + 1, j);
    int OvrMax = Math.max(resl.max, resr.max);
    int OvrMin = Math.min(resl.min, resr.min);

    return new Result(OvrMin, OvrMax);
  }

  public static void main(String[] args){
    int[] arr = {1, 2, 3, 4};
    Result r = MaxMin(arr, 0, arr.length-1);
    System.out.println("Min: " + r.min + " Max: " + r.max);
  }

}
