package com.media2359.euphoria.view.client.manpower;

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
  ValueProvider<WeeklyResourceRequest, Float> duration();
  ValueProvider<WeeklyResourceRequest, String> comment();  
}