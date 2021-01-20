package javaPrograms.Collections;

import java.util.ArrayList;

// T is of any type extending Number class
class Container<T extends Number> {
  T value;

  // To print class type of object
  public void show() {
    System.out.println(value.getClass().getName());
  }

  // ? can be of any type that extends T which internally extends Number
  public void demoForExtend(ArrayList<? extends T> obj) {}

  // ? can be of any type that is super class of T which internally extends Number
  public void demoForSuper(ArrayList<? super T> obj) {
    System.out.println(value.getClass().getSuperclass());
  }
}

public class GenericsDemo {

  public static void main(String[] args) {
    Container<Number> obj = new Container<>();
    obj.value = 9;
    obj.show();
    obj.demoForExtend(new ArrayList<Double>()); // Double extends Number
    obj.demoForSuper(new ArrayList<Object>()); // Object is super class of Number
  }
}
