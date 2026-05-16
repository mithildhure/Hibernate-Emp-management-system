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

public class Dept_Operations {

//	DONE BY ADMIN ONLY

//	calling it thru reference coz went in infinite emf creations 
	EntityManager em = Main.emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public void insert_Dept() {

		Department d = new Department();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Dept Id : ");
		int dept_id = sc.nextInt();
		System.out.println("Enter Dept Name : ");
		String dept_name = sc.next();

		d.setDepartment_id(dept_id);
		d.setDepartment_name(dept_name);

		et.begin();
		em.persist(d);
		System.out.println("Department Added Succesfully");
//		adding close coz went into some exceptions
		et.commit();

	}

	public void update_Dept() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Department Id : ");
		int dept_id = sc.nextInt();

		Department d = em.find(Department.class, dept_id);
		if (d != null) {
			System.out.println("Update Department Name : ");
			String dept_name = sc.next();

			d.setDepartment_name(dept_name);

			et.begin();
			em.merge(d);
			System.out.println("Department Details Updated");
			et.commit();
		} else {
			System.out.println("Department Not Found");
		}

	}

	
	public void remove_Dept() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Department Id : ");
		int dept_id = sc.nextInt();

		Department d = em.find(Department.class, dept_id);
		if (d != null) {
			
			List<Employee> emps = d.getEmp_lists();
			for(Employee emp : emps) {
				emp.setDepartment(null);
				em.merge(emp);
			}
			
			et.begin();
			em.remove(d);
			System.out.println("Department Removed");
			et.commit();
		}else {
			System.out.println("Department Not Found");
		}

	}
	
//	Emp in speciifc departments will be in nxt update
	public void fetch_Dept() {
		
		Query q = em.createQuery("Select dept from Department dept");
		
		List<Department> depts = q.getResultList();
		System.out.println("----Department Details----");
		for(Department dept : depts) {
			System.out.println("ID : "+dept.getDepartment_id());
			System.out.println("Name : "+dept.getDepartment_name());
			System.out.println("-----------------------------");
		}
		
		
	}

}
