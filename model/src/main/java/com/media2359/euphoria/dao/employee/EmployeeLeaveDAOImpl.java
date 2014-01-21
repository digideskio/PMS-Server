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
 * EmployeeLeaveDaoImpl
 *
 * TODO Write something about this class
 * 
 * @author TY
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
import com.media2359.euphoria.model.employee.EmployeeLeave;
import com.media2359.euphoria.model.project.Platform;
import com.media2359.euphoria.model.project.Project;
import com.media2359.euphoria.model.user.User;


@Repository
@Transactional(readOnly = true)
public class EmployeeLeaveDAOImpl extends HibernateDaoSupport implements EmployeeLeaveDAO {
	private final Logger log = Logger.getLogger(EmployeeLeaveDAOImpl.class);
	
	@Autowired
	public EmployeeLeaveDAOImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
	@SuppressWarnings("unchecked")
	public List<EmployeeLeave> getAllLeaves() {
		Session session = this.getSession();
		List<EmployeeLeave> employeeLeaves = null;
		try{
			Transaction tx1 = session.beginTransaction();
			employeeLeaves= this.getHibernateTemplate().find("from EmployeeLeave");
			tx1.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{session.close();}
		return employeeLeaves;
	}
	
	@SuppressWarnings("unchecked")
	public List<EmployeeLeave> getAllLeavesByEmployee(Employee employee, Date startDate, Date endDate){
		Session session = this.getSession(); 
		List<EmployeeLeave> employeeLeaves = null;
		try{
			Transaction tx1 = session.beginTransaction();
			employeeLeaves = this.getHibernateTemplate().find("from EmployeeLeave a where a.employee = ? "
					+ "and a.leaveDate >= ? and a.leaveDate <= ?", new Object[]{employee, startDate, endDate});
			 
			System.out.println("EmployeeLeave received from the database is "+employeeLeaves);
			tx1.commit();
		}catch(Exception e){
			
		}finally{session.close();}
		 return employeeLeaves;
	}
	
	@SuppressWarnings("unchecked")
	public Integer getMaxKey() {
		Session session = this.getSession();
		Integer maxKey = Integer.valueOf(-1);
		try{
			Transaction tx1 = session.beginTransaction();
			Query query = session.createQuery("select max(employeeLeaveKey) from Employee");
			
			
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
}
