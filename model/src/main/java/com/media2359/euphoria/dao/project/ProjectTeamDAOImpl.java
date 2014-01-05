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
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.media2359.euphoria.model.project.Project;
import com.media2359.euphoria.model.project.ProjectTeam;
import com.media2359.euphoria.view.dto.project.ProjectDTO;

@Repository
//@Transactional(readOnly = true)
public class ProjectTeamDAOImpl extends HibernateDaoSupport implements ProjectTeamDAO {
	private final Logger log = Logger.getLogger(ProjectTeamDAOImpl.class);
	
	@Autowired
	public ProjectTeamDAOImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
	@SuppressWarnings("unchecked")
	public List<ProjectTeam> getAllProjectTeams() {
		Session session = this.getSession();
		List<ProjectTeam> projectTeams = null;
		try{
		Transaction tx1 = session.beginTransaction();
		 projectTeams =  this.getHibernateTemplate().find("from ProjectTeam");
		}catch(Exception e){
			 
		 }finally{session.close();}
		 
		 return projectTeams;
	}
	
	@SuppressWarnings("unchecked")
	public ProjectTeam getProjectTeam(Integer projectTeamKey) {
		Session session = this.getSession();
		ProjectTeam tmpProjectTeam = null;
		try{
		Transaction tx1 = session.beginTransaction();

		tmpProjectTeam = (ProjectTeam) session.get(ProjectTeam.class, projectTeamKey);
		tx1.commit();
		}catch(Exception e){
			
		}finally{session.close();}
		return tmpProjectTeam;
	}
	
	@SuppressWarnings("unchecked")
	public Integer getMaxKey() {
		Session session = this.getSession();
		ListIterator iterator = null;
		try{
		log.info("## I am here 0 ...");
		Transaction tx1 = session.beginTransaction();
		log.info("## I am here 1 ...");
		Query query = session.createQuery("select max(projectTeamKey) from ProjectTeam");
		
//		Object[] rows = new Object[1];
		log.info("## I am here 2 ...");
		List results  = query.list();
		
		log.info("results::"+results.toString());
		log.info("results::"+results.size());
/*		for (Iterator it = results.iterator() ; it.hasNext(); )
		{
			rows = (Object[])it.next();
			
		}
		log.info("rows[0].class"+rows[0].getClass().toString());
		return (Integer) rows[0];*/
		
		iterator = results.listIterator();
		log.info("iterator.hasNext()::"+iterator.hasNext());
		//log.info("iterator.next().getClass::"+iterator.next().getClass().toString());
//		java.lang.Object[] rows = (java.lang.Object[]) iterator.next();
		tx1.commit();
		
		}catch(Exception e){
			//"ToDo"
		}
		finally {
			log.info("## I am here 3 ...");
			session.close();
			log.info("## I am here 4 ...");
		}
		return (Integer) (iterator.hasNext()?iterator.next():Integer.valueOf(-1));
	}
	
	@SuppressWarnings("unchecked")
	public void addProjectTeam(ProjectTeam projectTeam) {
		Session session = this.getSession();
		try{
		session.beginTransaction();
		session.save(projectTeam);
		session.getTransaction().commit();
		}catch(Exception e){
			
		}finally{session.close();}
		
	}
	
	@SuppressWarnings("unchecked")
	public void deleteProjectTeam(Integer projectTeamKey) {
		Session session = this.getSession();
		try{
		Transaction tx1 = session.beginTransaction();
		
		Query q = session.createQuery("delete ProjectTeam where projectTeamKey=?");
		q.setInteger(0, projectTeamKey);
		
		log.info("deleteProjectTeam()->sQuery::" + q.toString());
		q.executeUpdate();
		tx1.commit();
		}catch(Exception e){
			
		}finally{session.close();}
		//session.close();
		
	}
	
	@SuppressWarnings("unchecked")
	public void updateProjectTeam(ProjectTeam projectTeam) {
		Session session = this.getSession();
		try{
		Transaction tx1 = session.beginTransaction();
		
		session.saveOrUpdate(projectTeam);
		
		tx1.commit();
		}catch(Exception e){
			
		}finally{session.close();}
		//session.close();
		
	}
	
}
