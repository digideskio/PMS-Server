package com.media2359.euphoria.view.client.manpower;

import com.google.gwt.editor.client.Editor.Path;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface ProjectProperties extends PropertyAccess<Project> {
  @Path("name")
  ModelKeyProvider<Project> key();
  
  ValueProvider<Project, String> name();
}