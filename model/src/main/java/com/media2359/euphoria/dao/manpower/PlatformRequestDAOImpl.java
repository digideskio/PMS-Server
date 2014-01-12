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
import com.media2359.euphoria.model.manpower.PlatformRequest;
import com.media2359.euphoria.model.manpower.WeeklyManpowerRequest;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.media2359.euphoria.model.project.*;

/**
 *
 * TODO Write something about this class
 * 
 * @author ty
 * @version 1.0 2013
 **/

public class PlatformRequestDAOImpl extends HibernateDaoSupport implements PlatformRequestDAO {
	private Logger log = Logger.getLogger(PlatformRequestDAOImpl.class);
	@Autowired
	public PlatformRequestDAOImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
	@SuppressWarnings("unchecked")
	public List<PlatformRequest> findAllPlatformRequest(WeeklyManpowerRequest weeklyManpowerRequest){
		Session session = this.getSession();
		List<PlatformRequest> platformRequests = null;
		try{
			Transaction tx1 = session.beginTransaction();
			log.info("#### before find WeeklyManpowerRequest ####");
			platformRequests =  this.getHibernateTemplate().find("from PlatformRequest a where a.weeklyManpowerRequest = ? ",
										new Object[]{weeklyManpowerRequest});
			
			/*weeklyManpowerRequests =  this.getHibernateTemplate().find("from WeeklyManpowerRequest");
			log.info("#### after find WeeklyManpowerRequest ####");*/
			
			tx1.commit();
		}catch(Exception e){
			log.info(e);
		}finally{
			session.close();
		}
			 
		return platformRequests;
	}
	
	@SuppressWarnings("unchecked")
	public Integer getMaxKey() {
		Session session = this.getSession();
		Integer maxKey = Integer.valueOf(-1);
		try{
			Transaction tx1 = session.beginTransaction();
			Criteria crit = session.createCriteria(Platform.class); 
			crit.setProjection(Projections.max("platformRequestKey"));
			List<Integer> maxKeys = crit.list();
			log.info("results::"+maxKeys.toString());
			log.info("results::"+maxKeys.size());
			maxKey= (maxKeys.get(0)==null?Integer.valueOf(-1):maxKeys.get(0));
			tx1.commit();
		}catch(Exception e){
			
		}finally{session.close();}
		return maxKey;
	}
	
	@SuppressWarnings("unchecked")
	public void addPlatformRequest(PlatformRequest platformRequest){
		Session session = this.getSession();
		try{
		session.beginTransaction();
		session.save(platformRequest);
		session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{session.close();}
		
	}

}
