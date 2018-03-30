package com.java.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.java.proxy.*;

public class Provider_Client {
	public static void main(String[] args) {

		boolean result;
		Employee emp = new Employee();
		EmployeeProviderService service = new EmployeeProviderService();
		Scanner scan = new Scanner(System.in);
		List<Employee> list = new ArrayList<>();

		for (;;) {
			System.out.println(
					"Employee Management \n 1-> Find by ID \n 2->Find by Name \n 3-> ADD Employee \n 4-> UPDATE employee \n 5-> REMOVE Employee \n 6-->LIST of Employees \n 7-> EXIT");
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the Employee ID you want to search: ");
				emp.setId(scan.nextInt());
				result = service.getEmployeeProviderPort().findEmployee(emp.getId());
				if (result)
					System.out.println("Employee Exists");
				else
					System.out.println("Employee doesn't exist");
				break;

			case 2:
				System.out.println("Enter the name of the employee you want to search: ");
				emp.setName(scan.next());

				list = service.getEmployeeProviderPort().findByName(emp.getName());

				if (list.size() == 0)
					System.out.println("Employee doesn't exist");
				else
					for (int i = 0; i < list.size(); i++)
						System.out.println(list.get(i));
				break;

			case 3:
				System.out.println("Add an Employee:");
				System.out.println("Enter id:");
				emp.setId(scan.nextInt());
				System.out.println("Enter name:");
				emp.setName(scan.next());
				System.out.println("Enter Address:");
				emp.setAddress(scan.next());
				result=service.getEmployeeProviderPort().add(emp.getId(), emp.getName(), emp.getAddress());
				if (result)
					System.out.println("Employee Added Successfully");
				else
					System.out.println("Employee not Added");
				
				break;

			case 4:
				System.out.println("Update an Employee");
				System.out.println("Enter id:");
				emp.setId(scan.nextInt());
				System.out.println("Enter name:");
				emp.setName(scan.next());
				System.out.println("Enter Address:");
				emp.setAddress(scan.next());
				result=service.getEmployeeProviderPort().update(emp.getId(), emp.getName(), emp.getAddress());
				
				if (result)
					System.out.println("Employee Updated Successfully");
				else
					System.out.println("Employee not Updated");
				break;

			case 5:
				System.out.println("Remove an Employee: Enter Id");
				emp.setId(scan.nextInt());
				result=service.getEmployeeProviderPort().remove(emp.getId());
				if (result)
					System.out.println("Employee Removed Successfully");
				else
					System.out.println("Employee not Removed");
				break;

			case 6:
				list = service.getEmployeeProviderPort().list();
				for (int i = 0; i < list.size(); i++)
					System.out.println(list.get(i));
				break;

			case 7:
				System.exit(1);
			}
		}

	}

}
