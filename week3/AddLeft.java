import java.util.Stack;

public class AddLeft {
  public static String eva(String exp){
    Stack<Character> ex = new Stack<>();
    Stack<String> val = new Stack<>();
    String res = "";
    for (int i = 0; i < exp.length(); i++){
      Character c = exp.charAt(i);
      if (c == '*' || c == '+' || c == '-' || c == '/') ex.push(c);
      else if (c == ')'){
        String e2 = val.pop();
        String e1 = val.pop();
        val.push("(" + e1 + ex.pop() + e2 + ")");
      }
      else{
        val.push(Character.toString(c));
      }
    }
    return val.pop();
  }
  public static void main(String[] args){
    String exp = "1+2)*3-4)*5-6)))";
    System.out.println(eva(exp));
  }
}
