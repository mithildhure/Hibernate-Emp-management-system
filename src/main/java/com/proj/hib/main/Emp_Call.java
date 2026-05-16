package com.proj.hib.main;

import java.util.Scanner;

import com.proj.hib.crud.Emp_Operations;

public class Emp_Call {

	Emp_Operations eo = new Emp_Operations();
	Scanner sc = new Scanner(System.in);
	
	public void emp_crud() {
		
		System.out.println("Select Employee Operation: ");
		System.out.println("1. Insert Employee");
		System.out.println("2. Update Employee");
		System.out.println("3. Remove Employee");
		System.out.println("4. Fetch Employees");
		System.out.println("5. Back");
		int op = sc.nextInt();
		
		switch (op) {
		case 1:
			eo.insertEmp();
			break;

		case 2:
			eo.updateEmp();
			break;
			
		case 3:
			eo.removeEmp();
			break;
			
		case 4:
			eo.displayEmp();
			break;
		
		case 5:
			System.out.println("Back");
			return;

			
		default:
			System.out.println("Invalid Operation");
			break;
		}
		
	}

}
