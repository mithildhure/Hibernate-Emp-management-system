package com.proj.hib.main;

import java.util.Scanner;

import com.proj.hib.crud.Dept_Operations;

public class Dept_Call {

	Dept_Operations od = new Dept_Operations();
	Scanner sc = new Scanner(System.in);
	
	public void dept_crud() {
		
		System.out.println("Select Employee Operation: ");
		System.out.println("1. Insert Department");
		System.out.println("2. Update Department");
		System.out.println("3. Remove Department");
		System.out.println("4. Fetch Department");
		System.out.println("5. Back ");
		int op = sc.nextInt();
		
		switch (op) {
		case 1:
			od.insert_Dept();
			break;

		case 2:
			od.update_Dept();
			break;
			
		case 3:
			od.remove_Dept();
			break;
			
		case 4:
			od.fetch_Dept();
			break;
			
		case 5:
			System.out.println("BAck");
			return;
			
		default:
			System.out.println("Incorrect Operation");
			break;
		}
		
	}
	
}
