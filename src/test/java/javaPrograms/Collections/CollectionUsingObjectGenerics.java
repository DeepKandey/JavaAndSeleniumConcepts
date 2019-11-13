package javaPrograms.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student implements Comparable<Student> {
	int roll_no;
	int marks;

	public Student(int roll_no, int marks) {
		this.roll_no = roll_no;
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student{" + "roll_no = " + roll_no + ", marks = " + marks + "}";
	}

	@Override
	public int compareTo(Student obj) {
		// TODO Auto-generated method stub
		return this.marks > obj.marks ? -1 : 1;
	}
}

public class CollectionUsingObjectGenerics {

	public static void main(String[] args) {

		List<Student> listObj = new ArrayList<>();
		listObj.add(new Student(1, 34));
		listObj.add(new Student(2, 64));
		listObj.add(new Student(3, 87));
		listObj.add(new Student(4, 20));

		System.out.println("---Using Comparable----");
		Collections.sort(listObj);

		for (Student s : listObj) {
			System.out.println(s);
		}
		
		System.out.println("---Using Comparator----");
		Collections.sort(listObj, (obj1, obj2) -> {
			return obj1.marks > obj2.marks ? 1 : -1;
		});

		for (Student s : listObj) {
			System.out.println(s);
		}

		
	}
}
