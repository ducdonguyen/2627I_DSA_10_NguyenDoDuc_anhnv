import java.io.*;
import java.util.*;

class Student{
  public int id;
  public String name;
  public double CGPA;
  public Student(int id, String name, double CGPA){
    this.id = id;
    this.name = name;
    this.CGPA = CGPA;
  }
}
class StudentComparator implements Comparator<Student>{
  @Override
  public int compare(Student x, Student y){
    if (Double.compare(y.CGPA, x.CGPA) == 0){
      if (x.name.equals(y.name)){
        return (y.id < x.id) ? -1: 1;
      }
      else{
        return x.name.compareTo(y.name);
      }
    }
    else{
      return (y.CGPA < x.CGPA) ? -1: 1;
    }
  }
}
public class StudentSort {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(reader.readLine().trim());
    ArrayList<Student> s = new ArrayList<>();
    for (int i = 0; i < n; i++){
      String line = reader.readLine();
      String[] tokens = line.trim().split("\\s+");
      s.add(new Student(Integer.parseInt(tokens[0]), tokens[1], Double.parseDouble(tokens[2])));
    }
    Collections.sort(s, new StudentComparator());
    for (Student tv: s){
      System.out.println(tv.name);
    }
  }
}