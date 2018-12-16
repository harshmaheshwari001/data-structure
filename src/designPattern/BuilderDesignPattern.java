package designPattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Employee1 {
	private int id;
	private String name;
	private int age;

	public Employee1() {
	};

	public Employee1(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return "id= " + this.id + "Name = " + this.name + " age=" + this.age;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}

	static class Builder {
		private int id;
		private String name;
		private int age;

		public Builder() {
		};

		public Builder setId(int id) {
			this.id = id;
			return this;
		};

		public Builder setName(String name) {
			this.name = name;
			return this;
		};

		public Builder setAge(int age) {
			this.age = age;
			return this;
		};

		public Employee1 build() {
			return new Employee1(this.id, this.name, this.age);
		}
	}

}

/**
 * Name Comparator sort in Ascending order
 **/
class NameComparator implements Comparator<Employee1> {

	public int compare(Employee1 first, Employee1 second) {
		if (first.getName().compareTo(second.getName()) > 1) {
			return 1;
		} else if (first.getName().compareTo(second.getName()) < 0) {
			return -1;
		} else {
			// return 0;
			return new AgeComparator().compare(first, second);
		}
		// return 0;
	}
}

/**
 * Age comparator sort in Descending order
 **/
class AgeComparator implements Comparator<Employee1> {
	public int compare(Employee1 first, Employee1 second) {

		return second.getAge() - first.getAge();
	}
}

public class BuilderDesignPattern {

	public static void main(String[] args) {
		ArrayList<String> strings = new ArrayList<String>();
		// strings.add("Hello, World!");
		// strings.add("Welcome to CoderPad.");
		strings.add("This pad is running Java " + Runtime.getRuntime());
		strings.stream().forEach(System.out::println);

		Employee1 e = new Employee1.Builder().setId(1).setName("Harsh").setAge(29).build();
		Employee1 e1 = new Employee1.Builder().setId(2).setName("Harsh").setAge(30).build();

		List<Employee1> list = new ArrayList<>();
		list.add(e);
		list.add(e1);
		Collections.sort(list, new NameComparator());
		// Collections.sort(list,new AgeComparator());

		list.stream().forEach(System.out::println);
	}

}
