/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.dao.employee;
/**
 * EmployeeDaoImpl
 *
 * TODO Write something about this class
 * 
 * @author Praveen
 * @version 1.0 2013
 **/

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.media2359.euphoria.model.employee.Employee;
import com.media2359.euphoria.model.project.Project;


@Repository
@Transactional(readOnly = true)
public class EmployeeDAOImpl extends HibernateDaoSupport implements EmployeeDAO {
	private final Logger log = Logger.getLogger(EmployeeDAOImpl.class);
	
	@Autowired
	public EmployeeDAOImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {
		Session session = this.getSession();
		List<Employee> employees = null;
		try{
			Transaction tx1 = session.beginTransaction();
			employees= this.getHibernateTemplate().find("from Employee");
			tx1.commit();
		}catch(Exception e){
			
		}finally{session.close();}
		return employees;
		 /*List<Employee> employeeList = new ArrayList<Employee>();
		 
		 Employee emp1  = new Employee();
		 emp1.setName("Alfred");
		 emp1.setCompanyEmail("alfred@companyemail.com");
		 emp1.setEmploymentType("Full Time");
		 emp1.setDesignation("Admin");
		 emp1.setPlatForms("Rails,iOS,HTML,Android");
		 emp1.setMobile("99999988");
		 emp1.setPersonalEmail("alfred@personalemail.com");
		 emp1.setMandayRate("1000");
		 emp1.setAssignedOffice("Vietnam");
		 emp1.setStartDate(new Date());
		 emp1.setStatus("Active");
		 employeeList.add(emp1);
		 
		 Employee emp2  = new Employee();
		 emp2.setName("Lung Sen");
		 emp2.setCompanyEmail("lungsen@companyemail.com");
		 emp2.setEmploymentType("Part Time");
		 emp2.setDesignation("Sale");
		 emp2.setPlatForms("HTML,Android");
		 emp2.setMobile("99998988");
		 emp2.setPersonalEmail("lungsen@personalemail.com");
		 emp2.setMandayRate("1000");
		 emp2.setAssignedOffice("Vietnam");
		 emp2.setStartDate(new Date());
		 emp2.setEndDate(null);
		 emp2.setStatus("Active");
		 employeeList.add(emp2);
		 
		 Employee emp3  = new Employee();
		 emp3.setName("May");
		 emp3.setCompanyEmail("may@companyemail.com");
		 emp3.setEmploymentType("Internship");
		 emp3.setDesignation("Designer");
		 emp3.setPlatForms("Rails,iOS");
		 emp3.setMobile("99898988");
		 emp3.setPersonalEmail("may@personalemail.com");
		 emp3.setMandayRate("1000");
		 emp3.setAssignedOffice("Singapore");
		 emp3.setStartDate(new Date());
		 emp2.setEndDate(null);
		 emp3.setStatus("Active");
		 employeeList.add(emp3);
		 
		 Employee emp4  = new Employee();
		 emp4.setName("TY");
		 emp4.setCompanyEmail("ty@companyemail.com");
		 emp4.setEmploymentType("Freelance");
		 emp4.setDesignation("Project Manager");
		 emp4.setPlatForms("HTML,iOS");
		 emp4.setMobile("99898988");
		 emp4.setPersonalEmail("ty@personalemail.com");
		 emp4.setMandayRate("1000");
		 emp4.setAssignedOffice("Singapore");
		 emp4.setStartDate(new Date());
		 emp2.setEndDate(null);
		 emp4.setStatus("Active");
		 employeeList.add(emp4);
		 
		 Employee emp5  = new Employee();
		 emp5.setName("Praveen");
		 emp5.setCompanyEmail("praveen@companyemail.com");
		 emp5.setEmploymentType("Part Timee");
		 emp5.setDesignation("UX");
		 emp5.setPlatForms("HTML,iOS");
		 emp5.setMobile("98898988");
		 emp5.setPersonalEmail("praveen@personalemail.com");
		 emp5.setMandayRate("1000");
		 emp5.setAssignedOffice("Singapore");
		 emp5.setStartDate(new Date());
		 emp2.setEndDate(null);
		 emp5.setStatus("Active");
		 employeeList.add(emp5);
		 
		 Employee emp6  = new Employee();
		 emp6.setName("Shiv");
		 emp6.setCompanyEmail("shiv@companyemail.com");
		 emp6.setEmploymentType("Full Time");
		 emp6.setDesignation("QA");
		 emp6.setPlatForms("Rails,iOS,HTML,Android");
		 emp6.setMobile("98888988");
		 emp6.setPersonalEmail("shiv@personalemail.com");
		 emp6.setMandayRate("1000");
		 emp6.setAssignedOffice("Singapore");
		 emp6.setStartDate(new Date());
		 emp2.setEndDate(null);
		 emp6.setStatus("Active");
		 employeeList.add(emp6);
		 
		 return employeeList;*/
	}
	
	@SuppressWarnings("unchecked")
	public Employee getEmployee(Integer employeeKey) {
		Session session = this.getSession(); 
		Employee employee = null;
		try{
			Transaction tx1 = session.beginTransaction();
			employee = (Employee) this.getHibernateTemplate().get(Employee.class, employeeKey);
			 
			System.out.println("Employee received from the database is "+employee);
			tx1.commit();
		}catch(Exception e){
			
		}finally{session.close();}
		 return employee;
	}
	
	@SuppressWarnings("unchecked")
	public Integer getMaxKey() {
		Session session = this.getSession();
		Integer maxKey = Integer.valueOf(-1);
		try{
			Transaction tx1 = session.beginTransaction();
			Query query = session.createQuery("select max(employeeKey) from Employee");
			
			
			List results  = query.list();
			
			log.info("results::"+results.toString());
			log.info("results::"+results.size());
	
			
			ListIterator iterator = results.listIterator();
			log.info("iterator.hasNext()::"+iterator.hasNext());
	
			maxKey = ( (Integer) (iterator.hasNext()?iterator.next():Integer.valueOf(-1)));
			tx1.commit();
		}catch(Exception e){
			
		}finally{session.close();}
		 return maxKey;
	}
	
	@SuppressWarnings("unchecked")
	public void addEmployee(Employee employee) {
		Session session = this.getSession();
		try{

		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
		}catch(Exception e){
			
		}finally{session.close();}
		
	}
	
	@SuppressWarnings("unchecked")
	public void deleteEmployee(Integer employeeKey) {
		Session session = this.getSession();
		try{
		Transaction tx1 = session.beginTransaction();
		
		Query q = session.createQuery("delete Employee where employeeKey=?");
		q.setInteger(0, employeeKey);
		
		log.info("deleteEmployee()->sQuery::" + q.toString());
		q.executeUpdate();
		tx1.commit();
		//session.close();
		}catch(Exception e){
			
		}finally{session.close();}
	}
	
	@SuppressWarnings("unchecked")
	public void updateEmployee(Employee employee) {
		Session session = this.getSession();
		try{
		Transaction tx1 = session.beginTransaction();
		
		session.update(employee);
		
		tx1.commit();
		}catch(Exception e){
			
		}finally{session.close();}
		//session.close();
		
	}
}
