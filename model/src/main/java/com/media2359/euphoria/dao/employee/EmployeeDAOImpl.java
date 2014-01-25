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
import com.media2359.euphoria.model.manpower.PlatformRequest;
import com.media2359.euphoria.model.manpower.WeeklyManpowerRequest;
import com.media2359.euphoria.model.project.Platform;
import com.media2359.euphoria.model.project.Project;
import com.media2359.euphoria.model.user.User;


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
		log.info("#!#!#!#!#!  Adding Employeee...#!#!#!#!");
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
		}catch(Exception e){
			
		}finally{session.close();}
		
	}
	
	@SuppressWarnings("unchecked")
	public void deleteEmployee(Integer employeeKey) {
		log.info("#!#!#!#!#!  Deleting Employeee...#!#!#!#!");
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
		log.info("#!#!#!#!#!  Updating Employeee...#!#!#!#!");
		Session session = this.getSession();
		try{
		Transaction tx1 = session.beginTransaction();
		
		session.update(employee);
		
		tx1.commit();
		}catch(Exception e){
			
		}finally{session.close();}
		//session.close();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeesByPlatform(Platform platform){
		Session session = this.getSession(); 
		List<Employee> employees = null;
		try{
			Transaction tx1 = session.beginTransaction();
			
			employees = this.getHibernateTemplate().find("from Employee a inner join a.platForms b where b = ?", 
					new Object[]{platform});
			
			
			System.out.println("employees by platform received from the database is "+employees);
			tx1.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{session.close();}
		 return employees;
	}
	
	@SuppressWarnings("unchecked")
	public Employee getEmployeeByUserId(String userId){
		Session session = this.getSession();
		List<Employee> employees = null;
		Employee employee = null;
		try{
			Transaction tx1 = session.beginTransaction();
			employees =  this.getHibernateTemplate().find("from Employee a where a.companyEmail = ? "
					+ "order by a.employeeKey", new Object[]{userId});
			for (Employee tmpEmployee: employees){
				employee = tmpEmployee;
			}
			tx1.commit();
		}catch(Exception e){
			log.info(e);
		}finally{
			session.close();
		}
			 
		return employee;
	}
	
	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeesByRole(String role){
		Session session = this.getSession(); 
		List<Employee> employees = null;
		try{
			Transaction tx1 = session.beginTransaction();
			
			employees = this.getHibernateTemplate().find("from Employee a where a.designation = ?", 
					new Object[]{role});
			
			
			System.out.println("employees by role received from the database is "+employees);
			tx1.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{session.close();}
		 return employees;
	}
	
}
