package javaPrograms.ReflectionAPI;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

class ABC {}

public class ReflectionDemo {

  public static void main(String[] args) throws Exception {

    // Instantiating any class(Creating Object) using 'Class'class and calling
    // method
    /*
     * Class<? extends Object> c = Class.forName("javaPrograms.ReflectionAPI.Test");
     * Test test = (Test) c.getDeclaredConstructor().newInstance(); test.show();
     */

    // Using Reflection API, print Constructors
    Class<?> classObj = Class.forName("javaPrograms.ReflectionAPI.Test");
    System.out.println(
        "Private Parameterized Constructor: "
            + classObj.getDeclaredConstructor(String.class).toString());
    System.out.println("Public Constructor: " + classObj.getConstructor().toString());
    System.out.println(
        "All Constructors(Pubic,Private,Default,protected):\n "
            + Arrays.toString(classObj.getDeclaredConstructors()));

    // Get private constructor using getDeclaredConstructor. set it accessible and
    // then create the instance.
    Constructor<?> constructor = classObj.getDeclaredConstructor(String.class);
    constructor.setAccessible(true);
    Test test = (Test) constructor.newInstance(new String());

    // Get all methods(private,public, default,protected) using getDeclaredMethods.
    Method[] methodsList = classObj.getDeclaredMethods();
    System.out.println(
        "All Methods(Pubic,Private,Default,protected):\n" + Arrays.toString(methodsList));

    // Calling private non-parameterized method
    // Method method = classObj.getDeclaredMethod("show", null);
    Method method = classObj.getDeclaredMethod("show", new Class[] {});
    method.setAccessible(true);
    // method.invoke(test, null);
    method.invoke(test, new Object[] {});

    // Calling parameterized private method
    Method methodObj = classObj.getDeclaredMethod("cube", new Class[] {int.class});
    methodObj.setAccessible(true);
    methodObj.invoke(new Test(), 4);

    // Access Private field
    Field field = classObj.getDeclaredField("message");
    field.setAccessible(true);
    String value = field.get(new Test()).toString();
    System.out.println("Private Field value: " + value);

    // To determine whether given class is a class or interface
    Class<?> classObj2 = Class.forName("javaPrograms.ReflectionAPI.ABC");
    System.out.println("Is Class ABC an interface: " + classObj2.isInterface());

    // To determine the super class of the given class
    System.out.println("SuperClass of class ABC: " + classObj2.getSuperclass());
  } // End of method main
} // End of class ReflectionDemo
