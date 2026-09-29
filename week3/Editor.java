import java.io.*;
import java.util.*;

public class Editor {
  static class Operation{
    int type;
    String val;
    Operation(int type, String val){
      this.type = type;
      this.val = val;
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line = reader.readLine();
    int q = Integer.parseInt(line.trim());
    StringBuilder sb = new StringBuilder();
    Stack<Operation> st = new Stack<>();
    for (int i = 0; i < q; i++){
      line = reader.readLine();
      String[] tokens = line.trim().split("\\s+");
      int type = Integer.parseInt(tokens[0]);
      if (type == 1){
        sb.append(tokens[1]);
        st.push(new Operation(1, tokens[1]));
      }
      else if(type == 2){
        String res = sb.substring(sb.length() - Integer.parseInt(tokens[1]));
        sb.delete(sb.length() - Integer.parseInt(tokens[1]), sb.length());
        st.push(new Operation(2, res));
      }
      else if(type == 3){
        System.out.println(sb.charAt(Integer.parseInt(tokens[1]) -1));
      }
      else{
        Operation o = st.pop();
        if (o.type == 1) sb.delete(sb.length() - o.val.length(), sb.length());
        else sb.append(o.val);
      }
    }
  }
}