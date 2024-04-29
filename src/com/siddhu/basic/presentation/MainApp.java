package com.siddhu.basic.presentation;

import java.util.Scanner;

public class MainApp {
	static {
		System.out.println("+---------------------------------------------------------------------------------------------------+");
		System.out.println("|                                    MY COMPANY                                                     |");
		System.out.println("+---------------------------------------------------------------------------------------------------+");
	}

	public static void main(String[] args) {
		Integer choice = 0;
		App app = new AppImpl();
		Scanner sc = new Scanner(System.in);
		while (choice != 6) {
			System.out.println("____________________________________________________________________________________________________");
			System.out.print("\n1. Add Employee\t\t\t");
			System.out.print("2. Update Employee");
			System.out.println("\t\t\t3. Delete Employee");
			System.out.print("\n4. Find Employee by Id");
			System.out.print("\t\t5. Get All Employee\t\t\t");
			System.out.println("6. Exit");
			System.out.println("____________________________________________________________________________________________________");

			choice = sc.nextInt();
			switch (choice) {
			case 1:
				app.addEmployee();
				break;
			case 2:
				app.updateEmployee();
				break;
			case 3:
				app.deleteEmployee();
				break;

			case 4:
				app.findEmployeeById();
				break;

			case 5:
				app.getAllEmployee();
				break;

			case 6:
				System.out.println("User does not want to continue.");
				sc.close();
				break;

			default:
				System.out.println("Invalid Option!!!");
			}
		}
	}
}
