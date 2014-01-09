package com.media2359.euphoria.service.allocation;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.media2359.euphoria.dao.manpower.PlatformRequestDAO;
import com.media2359.euphoria.dao.manpower.WeeklyManpowerRequestDAO;
import com.media2359.euphoria.model.manpower.PlatformRequest;
import com.media2359.euphoria.model.manpower.WeeklyManpowerRequest;
import com.media2359.euphoria.model.project.Project;
import com.media2359.euphoria.view.dto.manpower.ProjectAllocationDTO;
import com.media2359.euphoria.view.dto.project.ProjectDTO;
import com.media2359.euphoria.view.server.allocation.RequestManpowerService;



@Service("RequestManpowerService")
public class RequestManpowerServiceImpl implements RequestManpowerService {

	@Autowired
	WeeklyManpowerRequestDAO weeklyManpowerRequestDao ;
	
	@Autowired
	PlatformRequestDAO platformRequestDao;            
	
	@Override
	public ProjectAllocationDTO requestManpower(ProjectDTO projectDto,
			Date startDate, Date endDate) {
		
		Project project = new Project();
		project.setId(projectDto.getId());
		List<WeeklyManpowerRequest> weeklyManpowerReqList = 
				weeklyManpowerRequestDao.findAllWklyMpowerRqstByProjectWeek(startDate, endDate, 
						project);
		List<PlatformRequest> platformReqList = platformRequestDao.findAllPlatformRequest(weeklyManpowerReqList.get(0));
		
		
		return null;
	}

}
