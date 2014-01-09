package com.media2359.euphoria.view.dto.milestone;

import java.util.Date;

public class MilestoneListRequest {
	Date startDate;
	Date endDate;
	
	public MilestoneListRequest() {
		// TODO Auto-generated constructor stub
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
