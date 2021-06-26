package javaPrograms.Lombook;

public class UserTest {

  public static void main(String[] args) {
    User user = new User("Shyam", 34, "Haridwar");
    System.out.println(
        "Original: " + user.getName() + " " + user.getAge() + " " + user.getAddress());
    System.out.println(user.toString());
    user.setAddress("Pune");
    System.out.println(
        "Updated: " + user.getName() + " " + user.getAge() + " " + user.getAddress());

    User user1 = User.builder().name("Ashish").address("Patna").age(45).build();
    System.out.println("User with builder Pattern:" + user1);
    System.out.println("User with no values: " + User.builder().build());
  }
}
