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

import com.media2359.euphoria.model.employee.Employee;
import com.media2359.euphoria.model.project.Platform;
import com.media2359.euphoria.model.project.Project;


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
		Session session = this.getSession();
		List<Project> projects = null;
		try{
			Transaction tx1 = session.beginTransaction();
			projects= this.getHibernateTemplate().find("from Project");
			tx1.commit();
		}catch(Exception e){
			
		}finally{session.close();}
		return projects;
	}
	
	@SuppressWarnings("unchecked")
	public Project getProject(Integer id) {
		
		Session session = this.getSession();
		Project project = null;
		try{
			Transaction tx1 = session.beginTransaction();
			project = (Project) this.getHibernateTemplate().get(Project.class, id);
			tx1.commit();
		}catch(Exception e){
			
		}finally{session.close();}
		return project;
	}
	
	@SuppressWarnings("unchecked")
	public Integer getMaxKey() {
		Session session = this.getSession();
		Integer maxKey = Integer.valueOf(-1);
		try{
			Transaction tx1 = session.beginTransaction();
			Criteria crit = session.createCriteria(Project.class); 
			crit.setProjection(Projections.max("id"));
			//crit.add(Restrictions.eq("id", 1));
			List<Integer> maxKeys = crit.list();
			log.info("results::"+maxKeys.toString());
			log.info("results::"+maxKeys.size());
			//log.info("Class Type::" + maxKeys.get(0).TYPE);
			maxKey= (maxKeys.get(0)==null?Integer.valueOf(-1):maxKeys.get(0));
			tx1.commit();
		}catch(Exception e){
			
		}finally{session.close();}
		return maxKey;
		/*session.getTransaction().begin();
		Query query = session.createQuery("select max(id) from Project");
		
		
//		Object[] rows = new Object[1];
		
		List results  = query.list();
		
		//log.info("results::"+results.toString());
		//log.info("results::"+results.size());
		for (Iterator it = results.iterator() ; it.hasNext(); )
		{
			rows = (Object[])it.next();
			
		}
		log.info("rows[0].class"+rows[0].getClass().toString());
		return (Integer) rows[0];
		
		ListIterator iterator = results.listIterator();
		//log.info("iterator.hasNext()::"+iterator.hasNext());
		//log.info("iterator.next().getClass::"+iterator.next().getClass().toString());
//		java.lang.Object[] rows = (java.lang.Object[]) iterator.next();
		Integer maxKey = (Integer) (iterator.hasNext()?iterator.next():Integer.valueOf(-1));
		results.clear();
		session.getTransaction().commit();
		return maxKey;*/
		
	}
	
	@SuppressWarnings("unchecked")
	public void addProject(Project project) {
		Session session = this.getSession();
		try{
		Transaction tx1 = session.beginTransaction();
		session.save(project);
		tx1.commit();
		}catch(Exception e){
			
		}finally{session.close();}
	}
	
	@SuppressWarnings("unchecked")
	public void deleteProject(Integer id) {
		Session session = this.getSession();
		try{
		Transaction tx1 = session.beginTransaction();
		
		Query q = session.createQuery("delete Project where id=?");
		q.setInteger(0, id);
		
		log.info("deleteProject()->sQuery::" + q.toString());
		q.executeUpdate();
		tx1.commit();
		//session.close();
		}catch(Exception e){
			
		}finally{session.close();}
	}
	
	@SuppressWarnings("unchecked")
	public void updateProject(Project project) {
		Session session = this.getSession();
		try{
		Transaction tx1 = session.beginTransaction();
		
		session.update(project);
		
		tx1.commit();
		}catch(Exception e){
			
		}finally{session.close();}
		//session.close();
		
	}
	
	@SuppressWarnings("unchecked")
	public Double getTotalApprovedMandays(Project project){
		Session session = this.getSession(); 
		List<Double> totalMandaysList = null;
		Double totalMandays = new Double(-1);
		try{
			Transaction tx1 = session.beginTransaction();
			
			totalMandaysList = this.getHibernateTemplate().find("select sum(date(a.endDate)- date(a.startDate)) from PlatformRequest a where a.weeklyManpowerRequest.project = ? "
					+ "and a.weeklyManpowerRequest.approvalStatus = 'A'", 
					new Object[]{project});
			
			for (Double tmpTotalMandays: totalMandaysList){
				totalMandays = tmpTotalMandays;
			}
			
			System.out.println("total mandays from  database is "+totalMandays);
			tx1.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{session.close();}
		 return totalMandays;
	}
	
}
