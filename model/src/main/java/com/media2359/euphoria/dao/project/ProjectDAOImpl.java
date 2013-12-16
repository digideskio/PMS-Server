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

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
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
	public Project getProject(String id) {
		 Project tmpProject = (Project) this.getHibernateTemplate().get(Project.class, id);
		 return tmpProject;
	}
}
