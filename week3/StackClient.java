import java.util.Iterator;
import java.util.Stack;

public class StackClient {
  public static Stack<String> copy(Stack<String> org){
    Stack<String> temp = new Stack<>();
    Stack<String> copyStack = new Stack<>();

    for (String item: org){
      temp.push(item);
    }
    for (String item: temp){
      copyStack.push(item);
    }
    return copyStack;
  }
  public static void main(String[] args) {
    // Tạo stack ban đầu
    Stack<String> stack = new Stack<>();
    stack.push("A");
    stack.push("B");
    stack.push("C");

    // Gọi hàm copy
    Stack<String> copiedStack = copy(stack);

    // In kiểm tra
    System.out.print("Stack gốc: ");
    for (String s : stack) {
      System.out.print(s + " ");
    }

    System.out.print("\nStack bản sao: ");
    for (String s : copiedStack) {
      System.out.print(s + " ");
    }
  }
}
