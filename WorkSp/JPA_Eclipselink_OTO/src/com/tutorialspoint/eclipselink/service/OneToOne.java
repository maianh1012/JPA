package com.tutorialspoint.eclipselink.service;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tutorialspoint.eclipselink.entity.DepartmentOTO;
import com.tutorialspoint.eclipselink.entity.EmployeeOTO;

public class OneToOne {
	public static void main(String[] args) {
		   
		   EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
		   EntityManager entitymanager = emfactory.createEntityManager( );
		   entitymanager.getTransaction( ).begin( );

		   //Create Department Entity
		   DepartmentOTO department = new DepartmentOTO();
		   department.setName("Development");

		   //Store Department
		   entitymanager.persist(department);

		   //Create Employee Entity
		   EmployeeOTO employee = new EmployeeOTO();
		   employee.setEname("Satish");
		   employee.setSalary(45000.0);
		   employee.setDeg("Technical Writer");
		   employee.setDepartment(department);

		   //Store Employee
		   entitymanager.persist(employee);

		   entitymanager.getTransaction().commit();
		   entitymanager.close();
		   emfactory.close();
		   }

}
