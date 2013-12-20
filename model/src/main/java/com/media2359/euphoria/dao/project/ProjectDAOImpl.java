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
import com.media2359.euphoria.view.dto.project.ProjectDTO;

@Repository
@Transactional(readOnly = true)
public class ProjectDAOImpl extends HibernateDaoSupport implements ProjectDAO {
	private final Logger log = Logger.getLogger(ProjectDAOImpl.class);
	
	@Autowired
	public ProjectDAOImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
	@SuppressWarnings("unchecked")
	public List<Project> getAllProjects() {
		 return this.getHibernateTemplate().find("from Project");
	}
	
	@SuppressWarnings("unchecked")
	public Project getProject(Integer id) {
		 Project tmpProject = (Project) this.getHibernateTemplate().get(Project.class, id);
		 return tmpProject;
	}
	
	@SuppressWarnings("unchecked")
	public Integer getMaxKey() {
		Session session = this.getSession();
		Query query = session.createQuery("select max(id) from Project");
		
		
//		Object[] rows = new Object[1];
		
		List results  = query.list();
		
		log.info("results::"+results.toString());
		log.info("results::"+results.size());
/*		for (Iterator it = results.iterator() ; it.hasNext(); )
		{
			rows = (Object[])it.next();
			
		}
		log.info("rows[0].class"+rows[0].getClass().toString());
		return (Integer) rows[0];*/
		
		ListIterator iterator = results.listIterator();
		log.info("iterator.hasNext()::"+iterator.hasNext());
		//log.info("iterator.next().getClass::"+iterator.next().getClass().toString());
//		java.lang.Object[] rows = (java.lang.Object[]) iterator.next();
		return (Integer) (iterator.hasNext()?iterator.next():Integer.valueOf(-1));
		
	}
	
	@SuppressWarnings("unchecked")
	public void addProject(Project project) {
		Session session = this.getSession();

		session.beginTransaction();
		session.save(project);
		session.getTransaction().commit();
		
	}
	
	@SuppressWarnings("unchecked")
	public void deleteProject(Integer id) {
		Session session = this.getSession();

		Transaction tx1 = session.beginTransaction();
		
		Query q = session.createQuery("delete Project where id=?");
		q.setInteger(0, id);
		
		log.info("deleteProject()->sQuery::" + q.toString());
		q.executeUpdate();
		tx1.commit();
		//session.close();
		
	}
	
	@SuppressWarnings("unchecked")
	public void updateProject(Project project) {
		Session session = this.getSession();

		Transaction tx1 = session.beginTransaction();
		
		session.update(project);
		
		tx1.commit();
		//session.close();
		
	}
	
}
