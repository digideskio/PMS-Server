package com.media2359.euphoria.dao.project;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.media2359.euphoria.model.project.Project;

@Repository
@Transactional(readOnly = true)
public class ProjectDaoImpl extends HibernateDaoSupport implements ProjectDao {
	private final Logger log = Logger.getLogger(ProjectDaoImpl.class);
	
	@Autowired
	public ProjectDaoImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
	@SuppressWarnings("unchecked")
	public List<Project> getAllProjects() {
		 return this.getHibernateTemplate().find("from Project");
	}
}
