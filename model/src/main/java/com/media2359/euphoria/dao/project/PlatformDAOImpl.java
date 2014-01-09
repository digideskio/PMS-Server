/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.dao.project;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.media2359.euphoria.model.project.*;


@Repository
@Transactional(readOnly = true)
public class PlatformDAOImpl extends HibernateDaoSupport implements PlatformDAO {
	private final Logger log = Logger.getLogger(PlatformDAOImpl.class);
	
	@Autowired
	public PlatformDAOImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
	@SuppressWarnings("unchecked")
	public List<Platform> findAllPlatforms() {
		Session session = this.getSession();
		List<Platform> platforms = null;
		try{
			Transaction tx1 = session.beginTransaction();
			platforms= this.getHibernateTemplate().find("from Platform");
			tx1.commit();
		}catch(Exception e){
			
		}finally{session.close();}
		return platforms;
	}
	
	@SuppressWarnings("unchecked")
	public Integer getMaxKey() {
		Session session = this.getSession();
		Integer maxKey = Integer.valueOf(-1);
		try{
			Transaction tx1 = session.beginTransaction();
			Criteria crit = session.createCriteria(Platform.class); 
			crit.setProjection(Projections.max("platformKey"));
			List<Integer> maxKeys = crit.list();
			log.info("results::"+maxKeys.toString());
			log.info("results::"+maxKeys.size());
			maxKey= (maxKeys.get(0)==null?Integer.valueOf(-1):maxKeys.get(0));
			tx1.commit();
		}catch(Exception e){
			
		}finally{session.close();}
		return maxKey;
	}
	
}
