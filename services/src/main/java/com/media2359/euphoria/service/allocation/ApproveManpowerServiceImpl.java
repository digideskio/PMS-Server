package com.media2359.euphoria.service.allocation;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.media2359.euphoria.dao.manpower.WeeklyManpowerRequestDAO;
import com.media2359.euphoria.model.manpower.WeeklyManpowerRequest;
import com.media2359.euphoria.model.project.Project;
import com.media2359.euphoria.view.dto.manpower.ProjectAllocationDTO;
import com.media2359.euphoria.view.server.allocation.ApproveManpowerService;

@Service("ApproveManpowerService")
public class ApproveManpowerServiceImpl implements ApproveManpowerService{

	@Autowired
	WeeklyManpowerRequestDAO weeklyManpowerRequestDao;
	
	@Override
	public String approveWeeklyRequest(
			ProjectAllocationDTO projectAllocationDTO) {
		
		WeeklyManpowerRequest weeklyManpowerRequest = new WeeklyManpowerRequest();
		weeklyManpowerRequest.setProject(new Project(projectAllocationDTO.getProjectDTO()));
		weeklyManpowerRequest.setComments("APPROVED");
		
		Date startOfWeek = formatDate(projectAllocationDTO.getStartOfWeek());
		weeklyManpowerRequest.setStartDate(startOfWeek);
		
		
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(startOfWeek);
		calendar.add(Calendar.DATE, 6);
		Date endOfWeek = new Date();
		endOfWeek.setTime(calendar.getTime().getTime());
		
		weeklyManpowerRequest.setEndDate(endOfWeek);
		weeklyManpowerRequest.setApprovalStatus("APPROVER");
		
		weeklyManpowerRequest.setApprovalStatus("A");
		weeklyManpowerRequestDao.approveWeeklyManpowerRequest(weeklyManpowerRequest);
		
		return "SUCCESS";
	}
	
	
	private Date formatDate(Date startOfWeek){
		Date formattedStartOfWeek=startOfWeek;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String strStartDate = simpleDateFormat.format(startOfWeek);
		System.out.println("Date is "+strStartDate);
		try{
			formattedStartOfWeek = simpleDateFormat.parse(strStartDate);
			System.out.println("New date is "+formattedStartOfWeek);
		}catch(Exception exp){
			
		}
		return formattedStartOfWeek;
	}

	

}
