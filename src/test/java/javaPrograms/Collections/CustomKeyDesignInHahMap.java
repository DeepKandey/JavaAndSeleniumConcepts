/** @author Deepak Rai */
package javaPrograms.Collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/** @author Deepak Rai */
public class CustomKeyDesignInHahMap {

  /**
   * {@summary }
   *
   * @param
   * @return
   * @author deepak rai
   */
  public static void main(String[] args) {

    HashMap<Employee, String> hashMapObj = new HashMap<>();

    Employee emp1 = new Employee(123);
    emp1.setEmployeName("Deepak");

    Employee emp2 = new Employee(123);
    emp2.setEmployeName("Pankaj");

    hashMapObj.put(emp1, emp1.getEmployeName());
    hashMapObj.put(emp2, emp2.getEmployeName());

    Set<Map.Entry<Employee, String>> entrySet = hashMapObj.entrySet();

    for (Map.Entry<Employee, String> entry : entrySet) {
      System.out.println(entry.getKey().toString() + " " + entry.getValue());
    }

    System.out.println(hashMapObj.get(emp1));
    System.out.println(hashMapObj.get(emp2));
  }
}

class Employee {

  private int employeeID;
  private String employeeName;

  public Employee(int employeeID) {
    this.employeeID = employeeID;
  }

  public int getEmployeID() {
    return employeeID;
  }

  public String getEmployeName() {
    return employeeName;
  }

  public void setEmployeName(String employeeName) {
    this.employeeName = employeeName;
  }

  // Depends only on account number
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    return prime * result + employeeID;
  }

  // Compare only account numbers
  @Override
  public boolean equals(Object b) {
    if (this == b) return true;
    if (b == null) return false;
    if (getClass() != b.getClass()) return false;

    Employee empObj = (Employee) b;
    if (employeeID != empObj.employeeID) return false;

    return true;
  }
}
