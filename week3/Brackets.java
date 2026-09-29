import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Brackets {
  public static boolean check(String inp){
    Stack<Character> stack = new Stack<>();
    Map<Character, Character> ngoac = new HashMap<>();
    ngoac.put(')', '(');
    ngoac.put(']', '[');
    ngoac.put('}', '{');
    for (int i = 0; i < inp.length(); i++){
      char c = inp.charAt(i);
      if (c == '(' || c == '[' || c == '{'){
        stack.push(c);
      }
      else if (c == ')' || c == ']' || c == '}'){
        if (stack.isEmpty() || stack.peek() != ngoac.get(c)) return false;
        else stack.pop();
      }
    }
    if (stack.isEmpty()) return true;
    else return false;
  }
  public static void main(String[] args){
    String exp = "((())";
    System.out.println(check(exp));
  }
}
