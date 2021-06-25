package javaPrograms.Lombook;

public class UserTest {

  public static void main(String[] args) {
    User user = new User("Shyam", 34, "Haridwar");
    System.out.println(user.getName() + " " + user.getAge() + " " + user.getAddress());
    System.out.println(user.toString());
    user.setAddress("Pune");
    System.out.println(user.getName() + " " + user.getAge() + " " + user.getAddress());
  }
}
