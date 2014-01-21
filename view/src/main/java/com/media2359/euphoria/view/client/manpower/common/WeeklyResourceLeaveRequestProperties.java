/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.view.client.manpower.common;

import java.util.Date;

import com.google.gwt.editor.client.Editor.Path;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface WeeklyResourceLeaveRequestProperties extends PropertyAccess<WeeklyResourceLeaveRequest> {
  @Path("id")
  ModelKeyProvider<WeeklyResourceLeaveRequest> key();
  
  ValueProvider<WeeklyResourceLeaveRequest, Date> weekStartDate();
  
  ValueProvider<WeeklyResourceLeaveRequest, Boolean> mondayMorning();
  ValueProvider<WeeklyResourceLeaveRequest, Boolean> mondayAfternoon();
  
  ValueProvider<WeeklyResourceLeaveRequest, Boolean> tuesdayMorning();
  ValueProvider<WeeklyResourceLeaveRequest, Boolean> tuesdayAfternoon();
  
  ValueProvider<WeeklyResourceLeaveRequest, Boolean> wednesdayMorning();
  ValueProvider<WeeklyResourceLeaveRequest, Boolean> wednesdayAfternoon();
  
  ValueProvider<WeeklyResourceLeaveRequest, Boolean> thursdayMorning();
  ValueProvider<WeeklyResourceLeaveRequest, Boolean> thursdayAfternoon();
  
  ValueProvider<WeeklyResourceLeaveRequest, Boolean> fridayMorning();
  ValueProvider<WeeklyResourceLeaveRequest, Boolean> fridayAfternoon();
}