/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.dao.milestone;
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
import com.media2359.euphoria.model.milestone.ProjectMilestone;
import com.media2359.euphoria.model.project.Platform;
import com.media2359.euphoria.model.project.Project;
import com.media2359.euphoria.model.user.User;


@Repository
@Transactional(readOnly = true)
public class ProjectMilestoneDAOImpl extends HibernateDaoSupport implements ProjectMilestoneDAO {
	private final Logger log = Logger.getLogger(ProjectMilestoneDAOImpl.class);
	
	@Autowired
	public ProjectMilestoneDAOImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
	@SuppressWarnings("unchecked")
	public List<ProjectMilestone> getAllProjectMilestone() {
		Session session = this.getSession();
		List<ProjectMilestone> projectMilestones = null;
		try{
			Transaction tx1 = session.beginTransaction();
			projectMilestones= this.getHibernateTemplate().find("from ProjectMilestone");
			tx1.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{session.close();}
		return projectMilestones;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProjectMilestone> getAllProjectMilestoneByProject(Project project){
		Session session = this.getSession(); 
		List<ProjectMilestone> projectMilestones = null;
		try{
			Transaction tx1 = session.beginTransaction();
			projectMilestones = this.getHibernateTemplate().find("from ProjectMilestone a where a.project = ? ", 
					new Object[]{project});
			 
			System.out.println("ProjectMilestones received from the database is "+projectMilestones);
			tx1.commit();
		}catch(Exception e){
			
		}finally{session.close();}
		 return projectMilestones;
	}
	
	@SuppressWarnings("unchecked")
	public Integer getMaxKey() {
		Session session = this.getSession();
		Integer maxKey = Integer.valueOf(-1);
		try{
			Transaction tx1 = session.beginTransaction();
			Query query = session.createQuery("select max(milestoneKey) from ProjectMilestone");
			
			
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
