package designPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * When to use the Proxy Pattern
	Proxy is applicable whenever there is a need for a more versatile or sophisticated reference to an object than a simple pointer.
	Here are several common situations in which the Proxy pattern is applicable:
		• A remote proxy provides a local representative for an object in a different address space.
		• A virtual proxy creates expensive objects on demand.
		• A protection proxy controls access to the original object. Protection proxies are useful when objects should have different
		access rights.
 * @author harsmahe
 *
 */

/**
 * Proxy design pattern which shows the use of Using Virtual Proxy.
 */
public class ProxyDesignPattern {

	public static void main(String args[]) {
		ContactList contactList = new ContactListImplProxy();
		Company company = new Company("Oracle", contactList);
		contactList = company.getContactList();
		for (Employee emp : contactList.getEmployeeList()) {
			System.out.printf("%s ,%s,%s", emp.getName(), emp.getSalary(), emp.getDesignation());
		}
	}
}

interface ContactList {
	public List<Employee> getEmployeeList();
}

class Company {
	private String companyName;
	private ContactList contactList;

	public Company(String companyName, ContactList contactList) {
		super();
		this.companyName = companyName;
		this.contactList = contactList;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public ContactList getContactList() {
		return contactList;
	}

	public void setContactList(ContactList contactList) {
		this.contactList = contactList;
	}

}

class ContactListImpl implements ContactList {

	@Override
	public List<Employee> getEmployeeList() {
		// TODO Auto-generated method stub
		return getStaticEmployee();
	}

	public static List<Employee> getStaticEmployee() {
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee("Test", 100, "A"));
		list.add(new Employee("Test1", 110, "B"));
		return list;
	}

}

/**
 * proxy class
 * 
 * @author harsmahe
 *
 */
class ContactListImplProxy implements ContactList {

	private ContactList contactList;

	@Override
	public List<Employee> getEmployeeList() {

		if (contactList == null) {
			// Create instance of Real object and return using Proxy
			contactList = new ContactListImpl();

		}
		return contactList.getEmployeeList();
	}

}

class Employee implements Comparable<String> {
	private final String name;
	private final double salary;
	private final String designation;

	public Employee(String name, double salary, String designation) {
		super();
		this.name = name;
		this.salary = salary;
		this.designation = designation;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public String getDesignation() {
		return designation;
	}

	@Override
	public int compareTo(String o) {
		return this.name.compareTo(o);
	}

}