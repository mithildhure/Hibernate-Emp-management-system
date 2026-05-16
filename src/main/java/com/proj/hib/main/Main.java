package com.proj.hib.main;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.proj.hib.entity.Admin;

public class Main {

	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("proj");
	EntityManager em = emf.createEntityManager();
	Emp_Call ec = new Emp_Call();
	Dept_Call dc = new Dept_Call();

	public void login() {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Username");
		String username = sc.next();

		System.out.println("Enter Password");
		String password = sc.next();

		Query q = em.createQuery("select a from Admin a where a.admin_user = ?1");
		q.setParameter(1, username);

		try {

			Admin a = (Admin) q.getSingleResult();
			if (a.getAdmin_pass().equals(password)) {
				System.out.println("Login Succesfull");

				while (true) {
					System.out.println("-----------------------------");
					System.out.println("Employee Management System : ");
					System.out.println("-----------------------------");
					System.out.println("Select Operation : ");
					System.out.println("1. Employee  ");
					System.out.println("2. Department ");
					System.out.println("3. Exit");
//					ADD OPTION TO CLOSE OR MOVE BACK
					int operation = sc.nextInt();

					switch (operation) {
					case 1:
						ec.emp_crud();
						break;

					case 2:
						dc.dept_crud();
						break;
						
					case 3:
						System.out.println("Thank You see again");
						System.exit(0);
						break;

					default:
						System.out.println("Invalid operation");
						break;
					}
				}

			} else {
				System.out.println("Invalid Password");
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Invalid Username");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Main m = new Main();
		m.login();
		
	}

}
