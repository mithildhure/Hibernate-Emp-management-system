package com.proj.hib.crud;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.proj.hib.entity.Department;
import com.proj.hib.entity.Employee;
import com.proj.hib.main.Main;

public class Emp_Operations {

	EntityManager em = Main.emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public void insertEmp() {

//		btw ctrl+shift+F aligns ur code ;)
		// only admin can do this
		// if insert then add emp first, then select Departments
		// cannot add new department while inserting emp

		System.out.println("---Insert Employee---");

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Employee Name : ");
		String emp_name = sc.next();

		System.out.println("Enter Employee Username : ");
		String emp_user = sc.next();

		System.out.println("Enter Employee Email : ");
		String emp_email = sc.next();

		System.out.println("Enter Employee Password : ");
		String password = sc.next();

		System.out.println("Enter Employee Salary : ");
		double salary = sc.nextDouble();

		System.out.println("Enter Employee Address: ");
		String address = sc.next();

//		SETTING EMPLOYEES

		Employee e = new Employee();
		e.setEmployee_name(emp_name);
		e.setEmp_username(emp_user);
		e.setEmp_email(emp_email);
		e.setPassword(password);
		e.setSalary(salary);
		e.setAddress(address);

		System.out.println("Select Department for emp: ");
		System.out.println("1. Sales ");
		System.out.println("2. HR ");
		System.out.println("3. IT ");
		System.out.println("4. Marketing ");
		int dept_id = sc.nextInt();

		switch (dept_id) {
		case 1:
			Department d1 = em.find(Department.class, 101);
			if (d1 != null) {
				e.setDepartment(d1);
				et.begin();
				em.persist(e);
				System.out.println("Emp inserted");
				et.commit();
			} else {
				System.out.println("failed to Insert EMP");
				break;
			}
			break;

		case 2:
			Department d2 = em.find(Department.class, 102);
			if (d2 != null) {
				e.setDepartment(d2);
				et.begin();
				em.persist(e);
				System.out.println("Emp Inserted");
				et.commit();
			} else {
				System.out.println("failed to Insert EMP");
				break;
			}
			break;

		case 3:
			Department d3 = em.find(Department.class, 103);
			if (d3 != null) {
				e.setDepartment(d3);
				et.begin();
				em.persist(e);
				System.out.println("Emp Inserted");
				et.commit();
			} else {
				System.out.println("failed to Insert EMP");
				break;
			}
			break;

		case 4:
			Department d4 = em.find(Department.class, 104);
			if (d4 != null) {
				e.setDepartment(d4);
				et.begin();
				em.persist(e);
				System.out.println("Emp Inserted");
				et.commit();
			} else {
				System.out.println("failed to Insert EMP");
				break;
			}
			break;

		default:
			System.out.println("Department Doesnt Exist");
			break;
		}

	}

	public void updateEmp() {
		Scanner sc = new Scanner(System.in);

		System.out.println("---Update Employee---");
		System.out.println("Enter Employee ID : ");
		int emp_id = sc.nextInt();

		Employee e1 = em.find(Employee.class, emp_id);
		if (e1 != null) {

			System.out.println("Enter Employee Name : ");
			String emp_name = sc.next();

			System.out.println("Enter Employee Username : ");
			String emp_user = sc.next();

			System.out.println("Enter Employee Email : ");
			String emp_email = sc.next();

			System.out.println("Enter Employee Password : ");
			String password = sc.next();

			System.out.println("Enter Employee Salary : ");
			double salary = sc.nextDouble();

			System.out.println("Enter Employee Address: ");
			String address = sc.next();

			e1.setEmployee_name(emp_name);
			e1.setEmp_username(emp_user);
			e1.setEmp_email(emp_email);
			e1.setPassword(password);
			e1.setSalary(salary);
			e1.setAddress(address);

			System.out.println("Select Department for emp: ");
			System.out.println("1. Sales ");
			System.out.println("2. HR ");
			System.out.println("3. IT ");
			System.out.println("4. Marketing ");
			int dept_id = sc.nextInt();

			switch (dept_id) {
			case 1:
				Department d1 = em.find(Department.class, 101);
				if (d1 != null) {
					e1.setDepartment(d1);
					et.begin();
					em.merge(e1);
					System.out.println("Emp Details Updated");
					et.commit();
				} else {
					System.out.println("failed to Update emp");
					break;
				}
				break;

			case 2:
				Department d2 = em.find(Department.class, 102);
				if (d2 != null) {
					e1.setDepartment(d2);
					et.begin();
					em.merge(e1);
					System.out.println("Emp Details Updated");
					et.commit();
				} else {
					System.out.println("failed to Update emp");
					break;
				}
				break;

			case 3:
				Department d3 = em.find(Department.class, 103);
				if (d3 != null) {
					e1.setDepartment(d3);
					et.begin();
					em.merge(e1);
					System.out.println("Emp Details Updated");
					et.commit();
				} else {
					System.out.println("failed to Update emp");
					break;
				}
				break;

			case 4:
				Department d4 = em.find(Department.class, 104);
				if (d4 != null) {
					e1.setDepartment(d4);
					et.begin();
					em.merge(e1);
					System.out.println("Emp Details Updated");
					et.commit();
				} else {
					System.out.println("failed to Update emp");
					break;
				}
				break;

			default:
				System.out.println("Department Doesnt Exist");
				break;
			}

		} else {
			System.out.println("Employee Not Found");
		}

	}

	public void removeEmp() {

		Scanner sc = new Scanner(System.in);

		System.out.println("---Remove Employee---");
		System.out.println("Enter Employee ID : ");
		int emp_id = sc.nextInt();
		
		Employee e = em.find(Employee.class, emp_id);
		if (e != null) {
			et.begin();
			em.remove(e);
			System.out.println("Employee Removed");
			et.commit();
		}else {
			System.out.println("Emp No Found");
		}
		
	}
	
	public void displayEmp() {
		
//		USING HQL FOR FETCING ALL
		
		Query q = em.createQuery("select emp from Employee emp");
		
		@SuppressWarnings("unchecked")
		List<Employee> emps = q.getResultList();
		
		System.out.println("---- Employee Details ----");
		System.out.println("--------------------------");
		for(Employee emp : emps) {
			System.out.println("Id :"+emp.getEmployee_id());
			System.out.println("Name :"+emp.getEmployee_name());
			Department d = emp.getDepartment();
			System.out.println("Department :"+ d.getDepartment_name());
			System.out.println("Salary :"+emp.getSalary());
			System.out.println("Email :"+emp.getEmp_email());
			System.out.println("Address :"+emp.getAddress());
			System.out.println("-----------------------------------");
		}
		
	}
	

}
