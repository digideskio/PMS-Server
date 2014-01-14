/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.dao.user;
/**
 * UserDaoImpl
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
import com.media2359.euphoria.model.project.Project;
import com.media2359.euphoria.model.project.ProjectTeam;
import com.media2359.euphoria.model.user.User;


@Repository
@Transactional(readOnly = true)
public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {
	private final Logger log = Logger.getLogger(UserDAOImpl.class);
	
	@Autowired
	public UserDAOImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		Session session = this.getSession();
		List<User> users = null;
		try{
			Transaction tx1 = session.beginTransaction();
			users= this.getHibernateTemplate().find("from User");
			tx1.commit();
		}catch(Exception e){
			
		}finally{session.close();}
		return users;
	}
	
	@SuppressWarnings("unchecked")
	public User getUserByKey(Integer userKey) {
		Session session = this.getSession(); 
		User user = null;
		try{
			Transaction tx1 = session.beginTransaction();
			user = (User) this.getHibernateTemplate().get(User.class, userKey);
			 
			System.out.println("User received from the database is "+user);
			tx1.commit();
		}catch(Exception e){
			
		}finally{session.close();}
		 return user;
	}
	
	@SuppressWarnings("unchecked")
	public User getUserById(String userId) {
		Session session = this.getSession(); 
		List<User> users = null;
		User user = null;
		try{
			Transaction tx1 = session.beginTransaction();
			
			users = this.getHibernateTemplate().find("from User a where a.userId = ?", 
					new Object[]{userId});
			
			user = users.size()>0?users.get(0):null;
			System.out.println("User received from the database is "+user);
			tx1.commit();
		}catch(Exception e){
			
		}finally{session.close();}
		 return user;
	}
	
	@SuppressWarnings("unchecked")
	public Integer getMaxKey() {
		Session session = this.getSession();
		Integer maxKey = Integer.valueOf(-1);
		try{
			Transaction tx1 = session.beginTransaction();
			Query query = session.createQuery("select max(userKey) from User");
			
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
	public void addUser(User user) {
		Session session = this.getSession();
		try{

		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		}catch(Exception e){
			
		}finally{session.close();}
		
	}
	
	@SuppressWarnings("unchecked")
	public void deleteUser(Integer userKey) {
		Session session = this.getSession();
		try{
		Transaction tx1 = session.beginTransaction();
		
		Query q = session.createQuery("delete User where userKey=?");
		q.setInteger(0, userKey);
		
		log.info("deleteUser()->sQuery::" + q.toString());
		q.executeUpdate();
		tx1.commit();
		}catch(Exception e){
			
		}finally{session.close();}
	}
	
	@SuppressWarnings("unchecked")
	public void updateUser(User user) {
		Session session = this.getSession();
		try{
		Transaction tx1 = session.beginTransaction();
		
		session.update(user);
		
		tx1.commit();
		}catch(Exception e){
			
		}finally{session.close();}
		//session.close();
		
	}
}
