/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.view.client.manpower.request;

import com.google.gwt.editor.client.Editor.Path;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface WeeklyResourceRequestProperties extends PropertyAccess<WeeklyResourceRequest> {
  @Path("id")
  ModelKeyProvider<WeeklyResourceRequest> key();
  
  ValueProvider<WeeklyResourceRequest, String> resource();
  ValueProvider<WeeklyResourceRequest, String> platform();
  ValueProvider<WeeklyResourceRequest, String> startDate();
  ValueProvider<WeeklyResourceRequest, String> duration();
  ValueProvider<WeeklyResourceRequest, String> comment();  
}