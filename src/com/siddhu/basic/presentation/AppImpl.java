package com.siddhu.basic.presentation;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.siddhu.basic.model.Employee;
import com.siddhu.basic.service.MyService;
import com.siddhu.basic.service.MyServiceImpl;
import com.siddhu.basic.validation.MyValidation;

public class AppImpl implements App {
	MyService myService;
	Scanner sc = new Scanner(System.in);

	AppImpl() {
		myService = new MyServiceImpl();
	}

	@Override
	public void addEmployee() {
		Boolean run = true;
		while (run) {
			Integer id = null;
			String name = null;
			String role = null;
			Double salary = null;
			String joining_date = null;
			String gender = null;
			Boolean idFlag = true;
			Boolean nameFlag = true;
			while (idFlag) {
				System.out.print("Enter Id: ");
				id = sc.nextInt();
				if (MyValidation.checkId(id)) {
					idFlag = false;
					while (nameFlag) {
						System.out.print("Enter Name: ");
						name = sc.next();
						if (MyValidation.checkName(name)) {
							nameFlag = false;
							System.out.print("Enter Role: ");
							role = sc.next();
							System.out.print("Enter Salary: ");
							salary = sc.nextDouble();
							System.out.print("Enter date in form of(yyyy-mm-dd): ");
							joining_date = sc.next();
							System.out.print("Enter Gender: ");
							gender = sc.next();
							Employee e1 = new Employee();
							e1.setId(id);
							e1.setName(name);
							e1.setRole(role);
							e1.setSalary(salary);
							e1.setJoining_date(joining_date);
							e1.setGender(gender);
							if (myService.addEmployee(e1)) {
								System.out.println(name + " is added successfully");
							}
							System.out.println("Do you want to Add more Employee? ");
							Character ch = sc.next().charAt(0);
							if (ch.equals('n') || ch.equals('N')) {
								run = false;
								break;
							}
						} else {
							System.out.println("Type name in correct formate");
						}

					}
				} else {
					System.out.println("Id Should Positiove");
				}
			}
		}

	}

	@Override
	public void updateEmployee() {
		Boolean run = true;
		while (run) {
			String name = null;
			String role = null;
			Double salary = null;
			String joining_date = null;
			String gender = null;
			Integer id = null;
			Boolean nameFlag = true;
			Boolean idFlag = true;
			while (nameFlag) {
				System.out.print("Enter new Name: ");
				name = sc.next();
				if (MyValidation.checkName(name)) {
					nameFlag = false;
					System.out.println("Enter new Role: ");
					role = sc.next();
					System.out.println("Enter new Salary: ");
					salary = sc.nextDouble();
					System.out.println("Enter New Joining Date");
					joining_date = sc.next();
					System.out.println("Enter Gender: ");
					gender = sc.next();
					while (idFlag) {
						System.out.println("Enter Id u wanna Update: ");
						id = sc.nextInt();
						if (MyValidation.checkId(id)) {
							idFlag = false;
							Employee e2 = new Employee();
							e2.setName(name);
							e2.setRole(role);
							e2.setSalary(salary);
							e2.setJoining_date(joining_date);
							e2.setGender(gender);
							e2.setId(id);
							if (myService.updateEmployee(e2)) {
								System.out.println(name + " is Updated successfully");
							}
							System.out.println("Do you want to Update more Employee? ");
							Character ch = sc.next().charAt(0);
							if (ch.equals('n') || ch.equals('N')) {
								run = false;
								break;
							}
						} else {
							System.out.println("Id should Positive number");
						}
					}
				} else {
					System.out.println("Enter Name in Correct Formate");
				}
			}
		}

	}

	@Override
	public void deleteEmployee() {
		Boolean run = true;
		while (run) {
			Integer id1 = null;
			Boolean idFlag = true;
			while (idFlag) {
				System.out.println("Enter Id u wanna delete: ");
				id1 = sc.nextInt();
				if (MyValidation.checkId(id1)) {
					idFlag = false;
					if (myService.deleteEmployee(id1)) {
						System.out.println("Id Deleted ");
					}
					System.out.println("Do you want to Delete more Employee? ");
					Character ch = sc.next().charAt(0);
					if (ch.equals('n') || ch.equals('N')) {
						run = false;
						break;
					}
				} else {
					System.out.println("Id should positive number");
				}
			}
		}
	}

	@Override
	public void findEmployeeById() {
		Employee emp = new Employee();
		Boolean run = true;
		while (run) {
			Integer id2 = null;
			Boolean idFlag = true;
			System.out.println("Enter Id u wanna Find: ");
			id2 = sc.nextInt();
			if (MyValidation.checkId(id2)) {
				idFlag = false;
				emp = myService.findEmployeeById(id2);
				if (emp.getId() == null) {
					System.out.println("There is No Employee Try with new ID Please....");
					run = false;
					break;
				}
				while (emp != null) {
					System.out.println("____________________________________________________________");
					System.out.println("Id is: " + emp.getId());
					System.out.println("Name is: " + emp.getName());
					System.out.println("Role is: " + emp.getRole());
					System.out.println("Salary is: " + emp.getSalary());
					System.out.println("Joining Date is: " + emp.getJoining_date());
					System.out.println("Gender is: " + emp.getGender());
					System.out.println("____________________________________________________________");
					break;
				}

			}

			else {
				System.out.println("Id should Positive Number");
			}
			System.out.println("Do you want to Find more Employee? ");
			Character ch = sc.next().charAt(0);
			if (ch.equals('n') || ch.equals('N')) {
				run = false;
				break;
			}
		}
	}

	@Override
	public void getAllEmployee() {
		List<Employee> emps = myService.getAllEmployee();
		Iterator<Employee> itr = emps.listIterator();
		System.out.println("--------------------------------------------------------------------------");
		while (itr.hasNext()) {
			Employee emp = itr.next();
			System.out.println();
			System.out.println("Id is              : " + emp.getId());
			System.out.println("Name is            : " + emp.getName());
			System.out.println("Role is            : " + emp.getRole());
			System.out.println("Salary is          : " + emp.getSalary());
			System.out.println("Joining Date is    : " + emp.getJoining_date());
			System.out.println("Gender is          : " + emp.getGender());
			System.out.println("____________________________________________________________________");
		}
	}
}
