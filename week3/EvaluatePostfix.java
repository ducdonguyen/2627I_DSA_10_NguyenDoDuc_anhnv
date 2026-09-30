import java.util.Stack;

public class EvaluatePostfix {
  public static int evaluate(Character[] exp){
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < exp.length; i++) {
      char c = exp[i];
      if (c == '+' || c == '-' || c == '*' || c == '/') {
        int b = stack.pop();
        int a = stack.pop();
        if (c == '+') stack.push(a + b);
        if (c == '-') stack.push(a - b);
        if (c == '*') stack.push(a * b);
        if (c == '/') stack.push(a / b);
      } else {
        stack.push(Integer.parseInt(Character.toString(c)));
      }
    }
    return stack.pop();
  }
  public static void main(String[] args){
    Character[] ch = {'2', '3', '1', '*', '+', '9', '-'};
    System.out.println(evaluate(ch));
  }
}
