/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.dao.manpower;

import java.util.Date;
import java.util.Set;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.media2359.euphoria.model.employee.Employee;
import com.media2359.euphoria.model.manpower.WeeklyManpowerRequest;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.media2359.euphoria.model.project.*;

/**
 * WeeklyManpowerRequestDAOImpl
 *
 * TODO Write something about this class
 * 
 * @author ty
 * @version 1.0 2013
 **/

public class WeeklyManpowerRequestDAOImpl extends HibernateDaoSupport implements WeeklyManpowerRequestDAO {
	private Logger log = Logger.getLogger(WeeklyManpowerRequestDAOImpl.class);
	@Autowired
	public WeeklyManpowerRequestDAOImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
	@SuppressWarnings("unchecked")
	public List<WeeklyManpowerRequest> findAllWklyMpowerRqstByProjectWeek(Date startDate, Date endDate, Project project){
		Session session = this.getSession();
		List<WeeklyManpowerRequest> weeklyManpowerRequests = null;
		try{
			Transaction tx1 = session.beginTransaction();
			log.info("#### before find WeeklyManpowerRequest ####");
			weeklyManpowerRequests =  this.getHibernateTemplate().find("from WeeklyManpowerRequest a where a.startDate >= ? "
										+ "and a.endDate <= ? and a.project = ?", new Object[]{startDate, endDate, project});
			
			/*weeklyManpowerRequests =  this.getHibernateTemplate().find("from WeeklyManpowerRequest");
			log.info("#### after find WeeklyManpowerRequest ####");*/
			
			tx1.commit();
		}catch(Exception e){
			log.info(e);
		}finally{
			session.close();
		}
			 
		return weeklyManpowerRequests;
	}
	
	@SuppressWarnings("unchecked")
	public WeeklyManpowerRequest getManpowerRequest(Integer wklyManpowerRqstKey){
		Session session = this.getSession();
		List<WeeklyManpowerRequest> wklyManpowerRqsts = null;
		WeeklyManpowerRequest wklyManpowerRqst = null;
		try{
		Transaction tx1 = session.beginTransaction();
		wklyManpowerRqsts = this.getHibernateTemplate().find("from WeeklyManpowerRequest a where a.weeklyManpowerRequestKey = ?", 
				new Object[]{wklyManpowerRqstKey});
		
		wklyManpowerRqst = wklyManpowerRqsts.size()>0?wklyManpowerRqsts.get(0):null;
		tx1.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{session.close();}
		return wklyManpowerRqst;
	}
	
	@SuppressWarnings("unchecked")
	public Integer getMaxKey() {
		Session session = this.getSession();
		ListIterator iterator = null;
		try{
		Transaction tx1 = session.beginTransaction();
		Query query = session.createQuery("select max(weeklyManpowerRequestKey) from WeeklyManpowerRequest");
		
		List results  = query.list();
		
		iterator = results.listIterator();
		tx1.commit();
		
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return (Integer) (iterator.hasNext()?iterator.next():Integer.valueOf(-1));
	}
	
	@SuppressWarnings("unchecked")
	public void addWeeklyManpowerRequest(WeeklyManpowerRequest wklyManpowerRqst){
		Session session = this.getSession();
		try{
		session.beginTransaction();
		session.save(wklyManpowerRqst);
		session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{session.close();}
		
	}
	
	@SuppressWarnings("unchecked")
	public void deleteWeeklyManpowerRequest(Integer wklyManpowerRqstKey){
		Session session = this.getSession();
		try{
		Transaction tx1 = session.beginTransaction();
		
		Query q = session.createQuery("delete WeeklyManpowerRequest where wklyManpowerRqstKey=?");
		q.setInteger(0, wklyManpowerRqstKey);
		
		log.info("deleteWeeklyManpowerRequest()->sQuery::" + q.toString());
		q.executeUpdate();
		tx1.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{session.close();}
		
	}
	
	@SuppressWarnings("unchecked")
	public void updateWeeklyManpowerRequest(WeeklyManpowerRequest wklyManpowerRqst){
		Session session = this.getSession();
		try{
		Transaction tx1 = session.beginTransaction();
		
		session.saveOrUpdate(wklyManpowerRqst);
		
		tx1.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{session.close();}
		
	}
	

}
