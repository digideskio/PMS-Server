package com.media2359.euphoria.view.dto.manpower;

import java.io.Serializable;

public class DailyResourcePlanDTO implements Serializable{
	
	Integer day;
	String half ;
	public Integer getDay() {
		return day;
	}
	public void setDay(Integer day) {
		this.day = day;
	}
	public String getHalf() {
		return half;
	}
	public void setHalf(String half) {
		this.half = half;
	}
	
	public String toString(){
		return "DailyResourcePlan : Day is ["+day+ "] : Half is ["+half+"]"; 
	}
	
	
	

}
