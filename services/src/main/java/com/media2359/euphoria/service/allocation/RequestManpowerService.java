package com.media2359.euphoria.service.allocation;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.media2359.euphoria.model.manpower.WeeklyManpowerRequest;
import com.media2359.euphoria.model.project.Project;


@Service("RequestManpowerService")
public class RequestManpowerService implements com.media2359.euphoria.view.server.allocation.RequestManpowerService {

	@Override
	public String requestManpower(Project project,
			WeeklyManpowerRequest weeklyManpowerReq,Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return null;
	}

}
